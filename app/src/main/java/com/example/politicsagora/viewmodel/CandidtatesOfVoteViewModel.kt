package com.example.politicsagora.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote
import com.example.politicsagora.repository.APIGetCandidatesService
import com.example.politicsagora.repository.APIGetVoteCodeService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CandidtatesOfVoteViewModel : ViewModel() {

    val itemLiveData = MutableLiveData<List<Candidate>>()
    val loadingItemLiveData = MutableLiveData<Boolean>()
    var sgId: String = ""
    var sgTypecode: String = ""

    private var service: APIGetCandidatesService

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(APIGetCandidatesService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIGetCandidatesService::class.java)

    }

    fun fetchCandidateInfo() {
        loadingItemLiveData.value = true
        viewModelScope.launch {
            val candidateInfo = service.fetchCandidates(sgId, sgTypecode);
            itemLiveData.value = candidateInfo.candidates
        }
        loadingItemLiveData.value = false

    }
}