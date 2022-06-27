package com.example.algorithms_and_data_structures

import org.junit.Assert.*
import org.junit.Test

class HighArrayTest {
    private val maxSize = 100

    @Test
    fun findItemTrue() {
        val arr = HighArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertTrue(arr.find(55L))
    }

    @Test
    fun findItemFalse() {
        val arr = HighArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertFalse(arr.find(35L))
    }

    @Test
    fun getMaxNoItems() { // task 2.1
        val arr = HighArray(maxSize)
        assertEquals(-1, arr.max)
    }

    @Test
    fun getMaxItem() { // task 2.1
        val arr = HighArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertEquals(99, arr.max)
    }

    @Test
    fun removeMaxItem() { // task 2.2
        val arr = HighArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        val max = arr.removeMax()

        assertEquals(99, max)
    }

    @Test
    fun sortedArray() { // task 2.3
        val arr = HighArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        var sortedArr = emptyArray<Long>()

        for (i in 0..3) {
            sortedArr += arr.removeMax()
        }

        assertArrayEquals(arrayOf(99L, 77L, 55L, 44L), sortedArr)
    }

    @Test
    fun noDups() { // task 2.6
        val arr = HighArray(maxSize)
        arr.insert(77)
        arr.insert(55)
        arr.insert(23)
        arr.insert(77)
        arr.insert(55)
        arr.insert(55)
        arr.insert(99)

        arr.noDups()
        assertArrayEquals(arrayOf(77L, 55L, 23L, 99L), arr.toArray().toTypedArray())
    }
}
