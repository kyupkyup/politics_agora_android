package com.example.politicsagora.model

import com.google.gson.annotations.SerializedName

data class Votes (
    @SerializedName("item")
    val votes : List<Vote>
)