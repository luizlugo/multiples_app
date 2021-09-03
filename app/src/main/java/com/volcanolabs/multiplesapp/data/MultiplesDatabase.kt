package com.volcanolabs.multiplesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.volcanolabs.multiplesapp.data.entities.MultipleSearchValue

@Database(entities = [MultipleSearchValue::class], version = 1)
abstract class MultiplesDatabase : RoomDatabase() {
    abstract fun multiplesDao(): MultiplesDao
}