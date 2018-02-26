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
import org.junit.Test
import java.util.*

/**
 * @author manerfan
 * @date 2018/2/23
 */

class ElementarySort {
    companion object {
        val array: Array<Int> = Array(100) { Random().nextInt(100) - 50 }
    }

    @Test // 冒泡排序
    fun bubble() {
        Assert.assertTrue(array.copyOf().bubbleSort().print("Bubble Sort").checkSort())
    }

    @Test // 选择排序
    fun selection() {
        Assert.assertTrue(array.copyOf().selectionSort().print("Selection Sort").checkSort())
    }

    @Test // 插入排序
    fun insertion() {
        Assert.assertTrue(array.copyOf().insertionSort().print("Insertion Sort").checkSort())
    }

    @Test // 希尔排序
    fun shell() {
        Assert.assertTrue(array.copyOf().shellSort().print("Shell  Sort").checkSort())
    }
}

class MergeSort {
    companion object {
        val array: Array<Int> = Array(100) { Random().nextInt(100) - 50 }
    }

    @Test // 归并
    fun merge() {
        Assert.assertTrue(array.copyOf().mergeSort().print("Merge  Sort").checkSort())
    }

    @Test // 并行归并
    fun mergeParallel() {
        Assert.assertTrue(array.copyOf().mergeSort(true).print("MergeP Sort").checkSort())
    }
}

class QuickSort {
    companion object {
        val array: Array<Int> = Array(100) { Random().nextInt(100) - 50 }
    }

    @Test // 快速排序
    fun quick() {
        Assert.assertTrue(array.copyOf().quickSort().print("Quick  Sort").checkSort())
    }


    @Test // 快速排序
    fun quickParallel() {
        Assert.assertTrue(array.copyOf().quickSort(true).print("QuickP Sort").checkSort())
    }
}