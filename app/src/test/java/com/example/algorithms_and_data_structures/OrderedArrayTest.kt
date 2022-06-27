package com.example.algorithms_and_data_structures

import org.junit.Assert.*
import org.junit.Test

class OrderedArrayTest {
    private val maxSize = 100

    @Test
    fun findItemTrue() { // task 2.4, find already using binary search
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertEquals(1, arr.find(55L))
    }

    @Test
    fun findItemFalse() {
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertEquals(arr.size(), arr.find(35L))
    }

    @Test
    fun deleteItemTrue() { // task 2.4, delete already using binary search
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertTrue(arr.delete(55L))
    }

    @Test
    fun deleteItemFalse() {
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        assertFalse(arr.delete(35L))
    }

    @Test
    fun insertBinarySmallest() { // task 2.4
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        arr.insertBinary(20L)

        assertArrayEquals(arrayOf(20L, 44L, 55L, 77L, 99L), arr.toArray().toTypedArray())
    }

    @Test
    fun insertBinaryLargest() {
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        arr.insertBinary(120L)

        assertArrayEquals(arrayOf(44L, 55L, 77L, 99L, 120L), arr.toArray().toTypedArray())
    }

    @Test
    fun insertBinaryMiddle() {
        val arr = OrderedArray(maxSize)
        arr.insert(77)
        arr.insert(99)
        arr.insert(44)
        arr.insert(55)

        arr.insertBinary(60L)

        assertArrayEquals(arrayOf(44L, 55L, 60L, 77L, 99L), arr.toArray().toTypedArray())
    }

    @Test
    fun merge() { // task 2.5
        val merged = OrderedArray(maxSize)
        val arr = OrderedArray(maxSize)
        val arr1 = OrderedArray(maxSize)

        arr.insertBinary(55L)
        arr.insertBinary(20L)
        arr.insertBinary(5L)
        arr.insertBinary(40L)

        arr1.insertBinary(12L)
        arr1.insertBinary(10L)
        arr1.insertBinary(1L)
        arr1.insertBinary(100L)
        arr1.insertBinary(60L)

        arr.display()
        arr1.display()

        merged.merge(arr, arr1)
        merged.display()

        assertArrayEquals(arrayOf(1L, 5L, 10L, 12L, 20L, 40L, 55L, 60L, 100L), merged.toArray().toTypedArray())
    }
}