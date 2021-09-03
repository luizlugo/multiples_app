package com.volcanolabs.multiplesapp

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class MultiplesTest {
    private lateinit var multiples: Multiples

    @Before
    fun setup() {
        multiples = Multiples()
    }

    @Test
    fun testMultiples() {
        val multiples = multiples.calculateMultiples(21)
        assertEquals(multiples.last(), "BigTheory")
    }

    @Test
    fun testBigBangTheory() {
        val multiples = multiples.calculateMultiples(105)
        assertEquals(multiples.last(), "BigBangTheory")
    }
}