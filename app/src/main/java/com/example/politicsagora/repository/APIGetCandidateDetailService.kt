package com.example.politicsagora.repository

import com.example.politicsagora.model.CandidateDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface APIGetCandidateDetailService {
    @GET("/getCandidate")
    suspend fun fetchCandidatesDetail(
        @Query("sgId") sgId: String,
        @Query("sgTypecode") sgTypecode: String,
        @Query("candidateId") candidateId: String
    ): CandidateDetails

    companion object {
        const val BASE_URL = "http://10.0.2.2:3000"
    }
}