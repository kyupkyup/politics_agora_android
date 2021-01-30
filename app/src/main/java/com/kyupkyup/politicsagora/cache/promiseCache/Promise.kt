package com.kyupkyup.politicsagora.cache.promiseCache

import androidx.room.*
import com.kyupkyup.politicsagora.model.CandidateDetail
import com.kyupkyup.politicsagora.model.CandidateDetails

@Entity
data class Promise(

//    @ColumnInfo(name = "sgId") val sgId: String,
//    @ColumnInfo(name = "sgTypecode") val sgTypecode: String,
    @ColumnInfo(name = "candidateId") var candidateId: String?,
    @TypeConverters
    @ColumnInfo(name = "list") var list: List<CandidateDetail>

//    @ColumnInfo(name = "prmsOrd") var prmsOrd: List<CandidateDetails>?
//    @ColumnInfo(name = "prmsRealmName") var prmsRealmName: String?,
//    @ColumnInfo(name = "prmsTitle") var prmsTitle: String?,
//    @ColumnInfo(name = "prmmCont") var prmmCont: String?

){
    @PrimaryKey(autoGenerate = true) var promiseId: Int = 0
}