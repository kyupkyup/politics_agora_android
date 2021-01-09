package com.kyupkyup.politicsagora.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyupkyup.politicsagora.model.Candidate
import com.kyupkyup.politicsagora.repository.APIGetElectedService
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class CandidatesViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Candidate>>()
    val loadingItemLiveData = MutableLiveData<Boolean>()
    val resultItemLiveData = MutableLiveData<String>()

    private var service: APIGetElectedService

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(APIGetElectedService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIGetElectedService::class.java)
        fetchCandidateInfo()
    }

    fun fetchCandidateInfo() {
        loadingItemLiveData.value = true

        viewModelScope.launch {
            try {
                val candidateInfo = service.fetchElected("20180613", "3");
                itemLiveData.value = candidateInfo.candidates
            }
            catch (e: Throwable) {
                resultItemLiveData.value = "error"
            }


        }
        loadingItemLiveData.value = false

    }
}