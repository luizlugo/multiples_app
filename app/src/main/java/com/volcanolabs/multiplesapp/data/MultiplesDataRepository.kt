package com.volcanolabs.multiplesapp.data

import com.volcanolabs.multiplesapp.data.entities.MultipleSearchValue
import javax.inject.Inject

class MultiplesDataRepository @Inject constructor(
    private val multiplesDao: MultiplesDao
) : MultiplesRepository {
    override suspend fun addMultipleNumber(multiplesSearchValue: Int) =
        multiplesDao.insertMultipleSearchValue(MultipleSearchValue(value = multiplesSearchValue))
}