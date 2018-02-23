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

/**
 * 初级排序
 * @author manerfan
 * @date 2018/2/23
 */

/**
 * 冒泡排序
 */
fun <T : Comparable<T>> Array<T>.bubbleSort(): Array<T> {
    ((this.size - 2) downTo 0).forEach { i ->
        (0..i).forEach { j ->
            if (this[j] > this[j + 1]) this.exch(j, j + 1)
        }
    }

    return this
}

/**
 * 选择排序
 */
fun <T : Comparable<T>> Array<T>.selectionSort(): Array<T> {
    val latestIndex = this.size - 1
    this.indices.forEach { i ->
        val min = ((i + 1)..latestIndex).fold(i) { min, j ->
            if (this[j] < this[min]) j else min
        }
        this.exch(i, min)
    }

    return this
}

/**
 * 插入排序
 */
fun <T : Comparable<T>> Array<T>.insertionSort(step: Int = 1): Array<T> {
    val latestIndex = this.size - 1
    (step..latestIndex).forEach outerLoop@ { i ->
        (i downTo step step step).forEach { j ->
            if (this[j] < this[j - step]) this.exch(j - step, j)
            else return@outerLoop
        }
    }

    return this
}

/**
 * 希尔排序
 */
fun <T : Comparable<T>> Array<T>.shellSort(step: Int = 3): Array<T> {
    var h = 1
    while (h < this.size / step) {
        h = h * step + 1
    }

    while (h > 0) {
        this.insertionSort(h)
        h /= step
    }

    return this
}