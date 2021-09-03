package com.volcanolabs.multiplesapp.data

import com.volcanolabs.multiplesapp.data.entities.MultipleSearchValue

interface MultiplesRepository {
    suspend fun addMultipleNumber(multiplesSearchValue: Int)
}