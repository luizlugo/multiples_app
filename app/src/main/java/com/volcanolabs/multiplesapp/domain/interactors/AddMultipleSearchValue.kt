package com.volcanolabs.multiplesapp.domain.interactors

import com.volcanolabs.multiplesapp.data.MultiplesRepository
import javax.inject.Inject

class AddMultipleSearchValue @Inject constructor(
    private val multiplesRepository: MultiplesRepository
) {
    suspend fun execute(number: Int) {
        multiplesRepository.addMultipleNumber(number)
    }
}