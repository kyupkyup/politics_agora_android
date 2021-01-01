package com.example.politicsagora.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicsagora.model.CandidateDetail
import com.example.politicsagora.model.ParsedCandidateDetail
import com.example.politicsagora.repository.APIGetCandidateDetailService
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Integer.parseInt
import java.util.concurrent.TimeUnit

class DetailViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<ParsedCandidateDetail>>()
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
            itemLiveData.value = parseCandidateDetail(candidateDetailInfo.candidateDetails)
        }
        loadingItemLiveData.value = false

    }

    fun parseCandidateDetail(args : List<CandidateDetail>) : List<ParsedCandidateDetail>{
        // count
        // prmsOrd, prmsRealmName, prmsTitle, prmmCont
        val temp : List<ParsedCandidateDetail> = mutableListOf<ParsedCandidateDetail>(
            ParsedCandidateDetail(args[0].prmsOrd1, args[0].prmsRealmName1,args[0].prmsTitle1,args[0].prmmCont1),
            ParsedCandidateDetail(args[0].prmsOrd2, args[0].prmsRealmName2,args[0].prmsTitle2,args[0].prmmCont2),
            ParsedCandidateDetail(args[0].prmsOrd3, args[0].prmsRealmName3,args[0].prmsTitle3,args[0].prmmCont3),
            ParsedCandidateDetail(args[0].prmsOrd4, args[0].prmsRealmName4,args[0].prmsTitle4,args[0].prmmCont4),
            ParsedCandidateDetail(args[0].prmsOrd5, args[0].prmsRealmName5,args[0].prmsTitle5,args[0].prmmCont5),
            ParsedCandidateDetail(args[0].prmsOrd6, args[0].prmsRealmName6,args[0].prmsTitle6,args[0].prmmCont6),
            ParsedCandidateDetail(args[0].prmsOrd7, args[0].prmsRealmName7,args[0].prmsTitle7,args[0].prmmCont7),
            ParsedCandidateDetail(args[0].prmsOrd8, args[0].prmsRealmName8,args[0].prmsTitle8,args[0].prmmCont8),
            ParsedCandidateDetail(args[0].prmsOrd9, args[0].prmsRealmName9,args[0].prmsTitle9,args[0].prmmCont9),
            ParsedCandidateDetail(args[0].prmsOrd10, args[0].prmsRealmName10,args[0].prmsTitle10,args[0].prmmCont10)
        )
    return temp
    }
}