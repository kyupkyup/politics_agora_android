package com.kyupkyup.politicsagora.cache.promiseCache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kyupkyup.politicsagora.model.CandidateDetails


@Database(entities = arrayOf(Promise::class), version = 1, exportSchema = false)
@TypeConverters(Converter::class)

abstract class AppDataBase : RoomDatabase() {
    abstract fun promiseDAO() : PromiseDAO
}