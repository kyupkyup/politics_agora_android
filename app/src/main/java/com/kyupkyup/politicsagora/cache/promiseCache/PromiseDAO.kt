package com.kyupkyup.politicsagora.cache.promiseCache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PromiseDAO {
    @Query("SELECT * FROM promise")
    fun getAll(): LiveData<List<Promise>>

    @Query("SELECT * FROM promise WHERE candidateId IN (:candidateId)")
    fun getPromise(candidateId : String) : Promise?

    @Insert
    fun insert(vararg promise: Promise)

//    @Delete
//    fun delete(promise: Promise)
}