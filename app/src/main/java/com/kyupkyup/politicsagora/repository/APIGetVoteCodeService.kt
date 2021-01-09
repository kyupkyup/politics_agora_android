package com.kyupkyup.politicsagora.repository


import com.kyupkyup.politicsagora.model.Votes
import retrofit2.http.GET

interface APIGetVoteCodeService {
    @GET("/getVoteCode")
    suspend fun fetchVote() : Votes

    companion object{
        const val BASE_URL = "http://3.35.49.38:3001"
        const val server_base_url = "http://10.0.2.2:3000"
    }
}