package com.example.politicsagora.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicsagora.model.Vote
import com.example.politicsagora.repository.APIGetVoteCodeService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class VotesViewmodel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Vote>>()
    val loadingItemLiveData = MutableLiveData<Boolean>()

    private var service : APIGetVoteCodeService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(APIGetVoteCodeService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIGetVoteCodeService::class.java)
        fetchVoteInfo()
    }

    fun fetchVoteInfo(){
        loadingItemLiveData.value = true

        viewModelScope.launch {
            val voteInfo = service.fetchVote();
            itemLiveData.value = voteInfo.votes
        }
        loadingItemLiveData.value = false

    }
}