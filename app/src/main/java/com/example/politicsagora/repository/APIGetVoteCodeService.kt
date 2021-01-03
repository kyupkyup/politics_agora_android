package com.example.politicsagora.repository


import android.util.Log
import com.example.politicsagora.model.Vote
import com.example.politicsagora.model.Votes
import retrofit2.http.GET
import retrofit2.http.POST

interface APIGetVoteCodeService {
    @GET("/getVoteCode")
    suspend fun fetchVote() : Votes

    companion object{
        const val BASE_URL = "http://3.35.49.38:3001"
        const val server_base_url = "http://10.0.2.2:3000"
    }
}