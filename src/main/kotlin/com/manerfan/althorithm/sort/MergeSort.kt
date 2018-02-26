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
 * 归并排序
 * @author manerfan
 * @date 2018/2/23
 */

internal fun <T : Comparable<T>> Array<T>.merge(lo: Int, mid: Int, hi: Int): Array<T> {
    val aux = this.clone()

    var p = lo
    var q = mid + 1
    (lo..hi).forEach { i ->
        when {
            q > hi -> this[i] = aux[p++] // 右侧归并完
            p > mid -> this[i] = aux[q++] // 左侧归并完
            aux[p] < aux[q] -> this[i] = aux[p++] // 左侧小
            else -> this[i] = aux[q++] // 右侧小
        }
    }

    return this
}

internal fun <T : Comparable<T>> mergeSort(array: Array<T>, lo: Int, hi: Int): Array<T> {
    return when {
        hi - lo < 10 -> array.shellSort() // 小范围使用希尔排序
        hi > lo -> {
            val mid = lo + (hi - lo) / 2
            mergeSort(array, lo, mid)
            mergeSort(array, mid + 1, hi)
            array.merge(lo, mid, hi)
            array
        }
        else -> array
    }
}

class MergeSortTask<T : Comparable<T>>(
        private var array: Array<T>,
        private val lo: Int, private val hi: Int
) : RecursiveTask<Array<T>>() {
    override fun compute() = when {
        hi - lo < 10 -> array.shellSort()
        hi > lo -> {
            val mid = lo + (hi - lo) / 2

            val left = MergeSortTask(array, lo, mid)
            val right = MergeSortTask(array, mid + 1, hi)
            left.fork(); right.fork()
            left.join(); right.join()

            array.merge(lo, mid, hi)
        }
        else -> array
    }
}

internal val mergePool = ForkJoinPool()

fun <T : Comparable<T>> Array<T>.mergeSort(parallel: Boolean = false) = when (parallel) {
    true -> mergeSort(this, 0, this.size - 1)
    else -> mergePool.submit(MergeSortTask(this, 0, this.size - 1)).get()
}!!
