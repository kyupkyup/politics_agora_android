package com.kyupkyup.politicsagora.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyupkyup.politicsagora.model.Vote
import com.kyupkyup.politicsagora.repository.APIGetVoteCodeService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VotesViewmodel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Vote>>()
    val loadingItemLiveData = MutableLiveData<Boolean>()
    val resultItemLiveData = MutableLiveData<String>()

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
            try{

                val voteInfo = service.fetchVote();

                itemLiveData.value = voteInfo.votes
            }

            catch (e: Throwable) {
                Log.d("result", e.toString())
                resultItemLiveData.value = "error"

            }
        }
        loadingItemLiveData.value = false

    }
}