package com.example.politicsagora.repository

import com.example.politicsagora.model.Candidates
import retrofit2.http.GET
import retrofit2.http.Query

interface APIGetElectedService {
    @GET("/getElected")
    suspend fun fetchElected(
        @Query("sgId") sgId: String,
        @Query("sgTypecode") sgTypecode: String
    ): Candidates

    companion object {
        const val BASE_URL = "http://3.35.49.38:3001"
        const val server_base_url = "http://10.0.2.2:3000"
    }
}