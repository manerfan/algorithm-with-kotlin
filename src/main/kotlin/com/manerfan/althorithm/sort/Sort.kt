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
 * @author manerfan
 * @date 2018/2/23
 */

internal fun <T> Array<T>.exch(i: Int, j: Int): Array<T> {
    val n = this[i]; this[i] = this[j]; this[j] = n
    return this
}

fun <T : Comparable<T>> Array<T>.checkSort(): Boolean {
    this.reduce { acc, item -> if (item < acc) return false; item }
    return true
}

fun <T> Array<T>.print(name: String = "Sort"): Array<T> {
    println("$name:\t\t ${this.joinToString()}")
    return this
}

