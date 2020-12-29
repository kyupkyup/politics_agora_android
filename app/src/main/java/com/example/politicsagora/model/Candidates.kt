package com.example.politicsagora.model

import com.google.gson.annotations.SerializedName

data class Candidates (
    @SerializedName("item")
    val candidates : List<Candidate>
)