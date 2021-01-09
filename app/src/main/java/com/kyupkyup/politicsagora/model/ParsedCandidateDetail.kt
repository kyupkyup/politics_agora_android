package com.kyupkyup.politicsagora.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParsedCandidateDetail(
    var prmsOrd : String,
    var prmsRealmName : String,
    var prmsTitle: String,
    var prmmCont : String
        ) : Parcelable

