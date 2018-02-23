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

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * @author manerfan
 * @date 2018/2/23
 */

class ElementarySort {
    lateinit var array: Array<Int>

    @Before
    fun before() {
        array = arrayOf(4, 6, 2, 56, 8, 9, 1, 23, 56, 2, 4, -4, 0, -32, 98, -67, -3, 2)
    }

    @Test // 冒泡排序
    fun bubble() {
        Assert.assertTrue(array.bubbleSort().print("Bubble Sort").checkSort())
    }

    @Test // 选择排序
    fun selection() {
        Assert.assertTrue(array.selectionSort().print("Selection Sort").checkSort())
    }

    @Test // 插入排序
    fun insertion() {
        Assert.assertTrue(array.insertionSort().print("Insertion Sort").checkSort())
    }

    @Test // 希尔排序
    fun shell() {
        Assert.assertTrue(array.shellSort().print("Shell   Sort").checkSort())
    }
}