package com.example.gympass

import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SetNumberUnitTest {
    @Test
    fun testNoItem() {
        val set = arrayOf<Int>()
        val result: ArrayList<ArrayList<Int>> = getSubset(set, set.size - 1)
        println(result)
        /*expected

          [[]]

         */
    }

    @Test
    fun testOneItem() {
        val set = arrayOf(1)
        val result: ArrayList<ArrayList<Int>> = getSubset(set, set.size - 1)
        println(result)
        /*expected

          [[], [1]]

         */
    }

    @Test
    fun testTwoItems() {
        val set = arrayOf(1, 2)
        val result: ArrayList<ArrayList<Int>> = getSubset(set, set.size - 1)
        println(result)

        /*expected

          [[], [1], [2], [1, 2]]

         */
    }

    @Test
    fun testThreeItems() {
        val set = arrayOf(1, 2, 3)
        val result: ArrayList<ArrayList<Int>> = getSubset(set, set.size - 1)
        println(result)

        /*expected

          [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

         */
    }

    @Test
    fun testFourItems() {
        val set = arrayOf(1, 2, 3, 4)
        val result: ArrayList<ArrayList<Int>> = getSubset(set, set.size - 1)
        println(result)

        /*expected

          [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3], [4], [1, 4], [2, 4], [1, 2, 4], [3, 4], [1, 3, 4], [2, 3, 4], [1, 2, 3, 4]]

         */
    }

    @Test
    fun testErrorDuplicateItems() {
        val set = arrayOf(1, 1, 3, 4)
        val result: ArrayList<ArrayList<Int>> = getSubset(set, set.size - 1)
        println(result)
        /*expected

          Error (should not contain duplicate numbers)(I put it inside the recursive function, is not a good approach, just to unit test throw an exception )

         */
    }

    private fun getSubset(numbers: Array<Int>, index: Int): ArrayList<ArrayList<Int>> {
        if(numbers.size != numbers.distinct().count()) { throw Exception("should not contain duplicate numbers") }

        val subsets: ArrayList<ArrayList<Int>>
        if (index < 0) {
            subsets = ArrayList()
            subsets.add(ArrayList())
        } else {
            subsets = getSubset(numbers, index - 1)
            val number = numbers[index]
            val otherCombinations = ArrayList<ArrayList<Int>>()
            for (subset in subsets) {
                val newSubset = ArrayList<Int>()
                newSubset.addAll(subset)
                newSubset.add(number)
                otherCombinations.add(newSubset)
            }
            subsets.addAll(otherCombinations)
        }
        return subsets
    }
}