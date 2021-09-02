package com.volcanolabs.multiplesapp

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Multiples @Inject constructor() {
    fun calculateMultiples(number: Int): List<String> {
        val multiples = mutableListOf<String>()

        for (singleNum in 1..number) {
            var wasMultiple = false
            var finalString = ""

            if (isMultiple(singleNum, 3)) {
                finalString += "Big"
                wasMultiple = true
            }

            if (isMultiple(singleNum, 5)) {
                finalString += "Bang"
                wasMultiple = true
            }

            if (isMultiple(singleNum, 7)) {
                finalString += "Theory"
                wasMultiple = true
            }

            if (!wasMultiple) {
                multiples.add(singleNum.toString())
            } else {
                multiples.add(finalString)
            }
        }

        return multiples
    }

    private fun isMultiple(singleNum: Int, factor: Int): Boolean {
        return singleNum % factor == 0
    }
}