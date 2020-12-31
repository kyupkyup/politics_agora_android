package com.example.politicsagora.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.repository.APIGetCandidatesService
import com.example.politicsagora.repository.APIGetVoteCodeService
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class CandidatesViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Candidate>>()
    val loadingItemLiveData = MutableLiveData<Boolean>()

    private var service : APIGetCandidatesService

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(APIGetVoteCodeService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIGetCandidatesService::class.java)
        fetchCandidateInfo()
    }

    fun fetchCandidateInfo(){
        loadingItemLiveData.value = true

        viewModelScope.launch {
            val candidateInfo = service.fetchCandidates("20200415", "2");
            itemLiveData.value = candidateInfo.candidates
        }
        loadingItemLiveData.value = false

    }
}