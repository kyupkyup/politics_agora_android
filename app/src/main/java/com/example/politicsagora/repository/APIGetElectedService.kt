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
        const val BASE_URL = "http://10.0.2.2:3000"
    }
}