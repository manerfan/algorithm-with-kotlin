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
 * 堆排序
 * @author manerfan
 * @date 2018/2/26
 */

// 将k下沉，截止到n
internal fun <T : Comparable<T>> Array<T>.sink(lo: Int, hi: Int): Array<T> {
    var k = lo + 1
    var n = hi + 1

    while (2 * k <= n) {
        var i = 2 * k // 左节点
        if (i < n && this[i - 1] < this[i]) i++ // 找出较大的子节点
        if (this[k - 1] >= this[i - 1]) break // 下沉结束
        this.exch(k - 1, i - 1) // 交换数据，下沉
        k = i
    }

    return this
}

fun <T : Comparable<T>> Array<T>.heapSort(): Array<T> {
    // 构造有序堆
    ((this.size / 2 - 1) downTo 0).forEach { lo ->
        this.sink(lo, this.size - 1)
    }

    // 修复
    ((this.size - 1) downTo 1).forEach { hi ->
        this.exch(0, hi) // 将当前最大值后移
        this.sink(0, hi - 1) // 下沉，修复有序堆
    }

    return this
}
