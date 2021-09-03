package com.volcanolabs.multiplesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volcanolabs.multiplesapp.domain.interactors.AddMultipleSearchValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MultiplesViewModel @Inject constructor(
    private val mAddMultipleSearchValue: AddMultipleSearchValue,
    private val multiples: Multiples
) : ViewModel() {
    private val _multiplesObs: MutableLiveData<List<String>> = MutableLiveData()
    val multiplesObs: LiveData<List<String>> = _multiplesObs

    private fun addMultipleSearchValueToHistory(number: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            mAddMultipleSearchValue.execute(number)
        }
    }

    fun calculateMultiples(number: Int) {
        viewModelScope.launch {
            _multiplesObs.value = multiples.calculateMultiples(number)
            addMultipleSearchValueToHistory(number)
        }
    }
}