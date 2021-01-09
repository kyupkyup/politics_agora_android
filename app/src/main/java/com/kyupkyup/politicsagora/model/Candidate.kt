package com.kyupkyup.politicsagora.model

import com.google.gson.annotations.SerializedName

data class Candidate (
    @SerializedName("num")
    var num : String,
    var sgId : String,
    var sgTypecode : String,
    @SerializedName("huboid")
    var candidateId : String,
    @SerializedName("sggName")
    var  sgRegionName : String,
    @SerializedName("sdName")
    var cityName  : String,
    @SerializedName("wiwName")
    var adminCityName : String,
    var giho : String,
    var gihoSangse: String,
    @SerializedName("jdName")
    var party : String,
    @SerializedName("name")
    var candidateName :String,
    @SerializedName("hanjaName")

    var candidateChineseName : String,
    var gender : String,
    var birthday : String,
    var age : String,
    var addr : String,
    var jobId : String,
    var job : String,
    var eduId : String,
    var edu : String,
    var career1 : String,
    var career2 : String,
    var status : String
        )


/*
* [ { num: [ '1' ],
    sgId: [ '20200415' ],
    sgTypecode: [ '2' ],
    huboid: [ '100136749' ],
    sggName: [ '종로구' ],
    sdName: [ '서울특별시' ],
    wiwName: [ '종로구' ],
    giho: [ '1' ],
    gihoSangse: [ '' ],
    jdName: [ '더불어민주당' ],
    name: [ '이낙연' ],
    hanjaName: [ '李洛淵' ],
    gender: [ '남' ],
    birthday: [ '19521220' ],
    age: [ '67' ],
    addr: [ '서울특별시 종로구 송월길' ],
    jobId: [ '75' ],
    job: [ '정당인' ],
    eduId: [ '68' ],
    edu: [ '서울대학교 법과대학 법학과 졸업' ],
    career1: [ '(현)민주당 코로나19국난극복위원장' ],
    career2: [ '(전)제45대 국무총리' ],
    status: [ '등록' ] },
* */