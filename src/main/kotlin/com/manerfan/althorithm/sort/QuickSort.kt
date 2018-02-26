/*
 * ManerFan(http://manerfan.com). All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.manerfan.althorithm.sort

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask

/**
 * 快速排序
 * @author manerfan
 * @date 2018/2/24
 */

internal fun <T : Comparable<T>> Array<T>.partition(lo: Int, hi: Int): Int {
    var i = lo
    var j = hi

    var v = this[lo] // 切分值
    while (i <= hi && j >= lo && i < j) {
        while (this[++i] < v) if (i >= hi) break
        while (this[--j] > v) if (j <= lo) break
        if (i >= j) break
        this.exch(i, j) // 将小于v的值放到左侧，反之放到右侧
    }
    val mid = if (this[i] < v) i else j // 将v放到中间
    this.exch(lo, mid)
    return mid
}

/**
 * 三向切分
 */
internal fun <T : Comparable<T>> Array<T>.partition3w(lo: Int, hi: Int): Array<Int> {
    var lt = lo
    var gt = hi
    var i = lo + 1

    var v = this[lo]
    while (i <= gt && i <= hi) {
        when {
            v > this[i] -> this.exch(i, gt--)
            v < this[i] -> this.exch(i++, lt++)
            else -> i++
        }
    }

    return arrayOf(lt, gt)
}

internal fun <T : Comparable<T>> quickSort(array: Array<T>, lo: Int, hi: Int): Array<T> {
    return when {
        hi - lo < 10 -> array.shellSort() // 小范围使用希尔排序
        hi > lo -> {
            val mid = array.partition(lo, hi) // 切分
            quickSort(array, lo, mid - 1) // 递归排序左侧
            quickSort(array, mid + 1, hi) // 递归排序右侧
            array
        }
        else -> array
    }
}

class QuickSortTask<T : Comparable<T>>(
        private var array: Array<T>,
        private val lo: Int, private val hi: Int
) : RecursiveTask<Array<T>>() {
    override fun compute() = when {
        hi - lo < 10 -> array.shellSort()
        hi > lo -> {
            val midPair = array.partition3w(lo, hi)

            val left = MergeSortTask(array, lo, midPair[0])
            val right = MergeSortTask(array, midPair[1], hi)
            left.fork(); right.fork()
            left.join(); right.join()
            array
        }
        else -> array
    }
}

internal val quickPool = ForkJoinPool()

fun <T : Comparable<T>> Array<T>.quickSort(parallel: Boolean = false) = when (parallel) {
    true -> quickSort(this, 0, this.size - 1)
    else -> quickPool.submit(QuickSortTask(this, 0, this.size - 1)).get()
}!!
