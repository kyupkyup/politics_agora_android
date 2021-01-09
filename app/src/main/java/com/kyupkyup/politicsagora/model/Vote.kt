package com.kyupkyup.politicsagora.model

import com.google.gson.annotations.SerializedName

data class Vote (
    @SerializedName("num")
    var num : String,
    @SerializedName("sgId")
    var sgId : String,
    @SerializedName("sgName")
    var sgName : String,
    @SerializedName("sgTypecode")
    var sgTypecode : String,
    @SerializedName("sgVotedate")
    var sgVotedate : String
        )