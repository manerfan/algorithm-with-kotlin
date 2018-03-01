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

package com.manerfan.althorithm.search

/**
 * @author manerfan
 * @date 2018/3/1
 */

class HashSearch<K : Comparable<K>, V>(private val m: Int = 50) : Search<K, V>() {

    private var table = Array<BinarySearch<K, V>>(m) { BinarySearch() }

    private fun hash(key: K) = (key.hashCode() and 0x7fff_ffff) % m

    override fun put(key: K, value: V) = table[hash(key)].put(key, value)

    override fun remove(key: Any?) = table[hash(key as K)].remove(key)

    override fun get(key: Any?) = table[hash(key as K)].get(key)
}