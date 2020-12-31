package com.example.politicsagora.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.CandidateDetail
import com.example.politicsagora.repository.APIGetCandidateDetailService
import com.example.politicsagora.repository.APIGetCandidatesService
import com.example.politicsagora.repository.APIGetVoteCodeService
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class DetailViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<CandidateDetail>>()
    val loadingItemLiveData = MutableLiveData<Boolean>()

    var sgId: String = ""
    var sgTypecode: String = ""
    var candidateId: String = ""
    var sgRegionName: String = ""
    var cityName: String = ""
    var gihoSangse: String = ""
    var party: String = ""
    var candidateName: String = ""
    var candidateChineseName: String = ""
    var gender: String = ""
    var birthday: String = ""
    var age: String = ""
    var addr: String = ""
    var job: String = ""
    var edu: String = ""
    var career1: String = ""
    var career2: String = ""


    private var service: APIGetCandidateDetailService

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(APIGetCandidateDetailService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIGetCandidateDetailService::class.java)
    }

    fun fetchCandidateInfo() {
        loadingItemLiveData.value = true
        viewModelScope.launch {
            val candidateDetailInfo = service.fetchCandidatesDetail(sgId, sgTypecode, candidateId);
            itemLiveData.value = candidateDetailInfo.candidateDetails

        }
        loadingItemLiveData.value = false

    }
}