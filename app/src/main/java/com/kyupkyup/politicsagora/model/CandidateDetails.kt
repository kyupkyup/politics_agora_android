package com.kyupkyup.politicsagora.model

import com.google.gson.annotations.SerializedName

data class CandidateDetails (
    @SerializedName("item")
    val candidateDetails : List<CandidateDetail>
        )