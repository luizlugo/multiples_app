package com.volcanolabs.multiplesapp.data

import androidx.room.Dao
import androidx.room.Insert
import com.volcanolabs.multiplesapp.data.entities.MultipleSearchValue

@Dao
interface MultiplesDao {
    @Insert
    fun insertMultipleSearchValue(vararg multipleSearchValue: MultipleSearchValue)
}