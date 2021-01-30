package com.kyupkyup.politicsagora.cache.promiseCache

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kyupkyup.politicsagora.model.CandidateDetail

class Converter {
    var gson = Gson()

    @TypeConverter
    fun fromObjectToString(value: List<CandidateDetail>): String{
        return gson.toJson(value)
    }
    @TypeConverter
    fun fromStringToObject(data: String?) : List<CandidateDetail> {
        val listType = object : TypeToken<List<CandidateDetail>>(){

        }.type
        return gson.fromJson(data, listType)
    }
}