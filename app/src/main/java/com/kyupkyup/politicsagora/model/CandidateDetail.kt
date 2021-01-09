package com.kyupkyup.politicsagora.model

import com.google.gson.annotations.SerializedName

data class CandidateDetail (
    @SerializedName("num")
    var num : String,
    var sgId : String,
    var sgTypecode : String,
    @SerializedName("cnddtId")
    var candidateId : String,
    @SerializedName("sggName")
    var  sgRegionName : String,
    @SerializedName("sidoName")
    var cityName  : String,
    @SerializedName("wiwName")
    var wiwName : String,
    @SerializedName("partyName")
    var party : String,
    @SerializedName("krName")
    var candidateName :String,
    @SerializedName("cnName")
    var candidateChineseName : String,
    @SerializedName("prmsCnt")
    var prmsCnt : String,

    @SerializedName("prmsOrd1")
    var prmsOrd1 : String,
    @SerializedName("prmsRealmName1")
    var prmsRealmName1 : String,
    @SerializedName("prmsTitle1")
    var prmsTitle1 : String,
    @SerializedName("prmmCont1")
    var prmmCont1 : String,

    @SerializedName("prmsOrd2")
    var prmsOrd2 : String,
    @SerializedName("prmsRealmName2")
    var prmsRealmName2 : String,
    @SerializedName("prmsTitle2")
    var prmsTitle2 : String,
    @SerializedName("prmmCont2")
    var prmmCont2 : String,

    @SerializedName("prmsOrd3")
    var prmsOrd3 : String,
    @SerializedName("prmsRealmName3")
    var prmsRealmName3 : String,
    @SerializedName("prmsTitle3")
    var prmsTitle3 : String,
    @SerializedName("prmmCont3")
    var prmmCont3 : String,

    @SerializedName("prmsOrd4")
    var prmsOrd4 : String,
    @SerializedName("prmsRealmName4")
    var prmsRealmName4 : String,
    @SerializedName("prmsTitle4")
    var prmsTitle4: String,
    @SerializedName("prmmCont4")
    var prmmCont4 : String,

    @SerializedName("prmsOrd5")
    var prmsOrd5 : String,
    @SerializedName("prmsRealmName5")
    var prmsRealmName5 : String,
    @SerializedName("prmsTitle5")
    var prmsTitle5 : String,
    @SerializedName("prmmCont5")
    var prmmCont5 : String,

    @SerializedName("prmsOrd6")
    var prmsOrd6 : String,
    @SerializedName("prmsRealmName6")
    var prmsRealmName6 : String,
    @SerializedName("prmsTitle6")
    var prmsTitle6: String,
    @SerializedName("prmmCont6")
    var prmmCont6 : String,

    @SerializedName("prmsOrd7")
    var prmsOrd7 : String,
    @SerializedName("prmsRealmName7")
    var prmsRealmName7 : String,
    @SerializedName("prmsTitle7")
    var prmsTitle7 : String,
    @SerializedName("prmmCont7")
    var prmmCont7 : String,

    @SerializedName("prmsOrd8")
    var prmsOrd8 : String,
    @SerializedName("prmsRealmName8")
    var prmsRealmName8 : String,
    @SerializedName("prmsTitle8")
    var prmsTitle8 : String,
    @SerializedName("prmmCont8")
    var prmmCont8 : String,

    @SerializedName("prmsOrd9")
    var prmsOrd9 : String,
    @SerializedName("prmsRealmName9")
    var prmsRealmName9 : String,
    @SerializedName("prmsTitle9")
    var prmsTitle9 : String,
    @SerializedName("prmmCont9")
    var prmmCont9 : String,

    @SerializedName("prmsOrd10")
    var prmsOrd10 : String,
    @SerializedName("prmsRealmName10")
    var prmsRealmName10 : String,
    @SerializedName("prmsTitle10")
    var prmsTitle10 : String,
    @SerializedName("prmmCont10")
    var prmmCont10 : String



    )