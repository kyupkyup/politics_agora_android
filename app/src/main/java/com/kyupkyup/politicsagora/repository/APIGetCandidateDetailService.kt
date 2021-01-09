package com.kyupkyup.politicsagora.repository

import com.kyupkyup.politicsagora.model.CandidateDetails
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
        const val BASE_URL = "http://3.35.49.38:3001"
        const val server_base_url = "http://10.0.2.2:3000"
    }
}