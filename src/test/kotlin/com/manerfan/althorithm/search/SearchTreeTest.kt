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

import org.junit.Assert
import org.junit.Test

/**
 * @author manerfan
 * @date 2018/2/27
 */

class SearchTreeTest {

    @Test // 二叉查找树
    fun binarySearch() {
        var binarySearch = BinarySearch<Int, String>()
        binarySearch.put(1, "1")
        binarySearch.put(2, "2")

        Assert.assertEquals(binarySearch[1], "1")
        Assert.assertEquals(binarySearch[2], "2")
        Assert.assertNull(binarySearch[3])

        binarySearch.put(2, "b")
        Assert.assertNotEquals(binarySearch[2], "2")
        Assert.assertEquals(binarySearch[2], "b")

        binarySearch.put(5, "5")
        binarySearch.put(4, "4")
        binarySearch.put(6, "6")

        binarySearch.put(-5, "-5")
        binarySearch.put(-4, "-4")
        binarySearch.put(-6, "-6")

        binarySearch.remove(5)
        Assert.assertNull(binarySearch[5])

        binarySearch.remove(2)
        Assert.assertNull(binarySearch[2])

        binarySearch.remove(-4)
        Assert.assertNull(binarySearch[-4])

        binarySearch.remove(1)
        Assert.assertNull(binarySearch[1])
    }

    @Test // 二叉查找树
    fun balancedBinarySearch() {
        var balancedBinarySearch = BalancedBinarySearch<Int, String>()
        balancedBinarySearch.put(1, "1")
        balancedBinarySearch.put(2, "2")

        Assert.assertEquals(balancedBinarySearch[1], "1")
        Assert.assertEquals(balancedBinarySearch[2], "2")
        Assert.assertNull(balancedBinarySearch[3])

        balancedBinarySearch.put(2, "b")
        Assert.assertNotEquals(balancedBinarySearch[2], "2")
        Assert.assertEquals(balancedBinarySearch[2], "b")

        balancedBinarySearch.put(5, "5")
        balancedBinarySearch.put(4, "4")
        balancedBinarySearch.put(6, "6")

        balancedBinarySearch.put(-5, "-5")
        balancedBinarySearch.put(-4, "-4")
        balancedBinarySearch.put(-6, "-6")

        balancedBinarySearch.remove(5)
        Assert.assertNull(balancedBinarySearch[5])

        balancedBinarySearch.remove(2)
        Assert.assertNull(balancedBinarySearch[2])

        balancedBinarySearch.remove(-4)
        Assert.assertNull(balancedBinarySearch[-4])

        balancedBinarySearch.remove(1)
        Assert.assertNull(balancedBinarySearch[1])
    }

    @Test // 二叉查找树
    fun hashSearch() {
        var hashSearch = HashSearch<Int, String>()
        hashSearch.put(1, "1")
        hashSearch.put(2, "2")

        Assert.assertEquals(hashSearch[1], "1")
        Assert.assertEquals(hashSearch[2], "2")
        Assert.assertNull(hashSearch[3])

        hashSearch.put(2, "b")
        Assert.assertNotEquals(hashSearch[2], "2")
        Assert.assertEquals(hashSearch[2], "b")

        hashSearch.put(5, "5")
        hashSearch.put(4, "4")
        hashSearch.put(6, "6")

        hashSearch.put(-5, "-5")
        hashSearch.put(-4, "-4")
        hashSearch.put(-6, "-6")

        hashSearch.remove(5)
        Assert.assertNull(hashSearch[5])

        hashSearch.remove(2)
        Assert.assertNull(hashSearch[2])

        hashSearch.remove(-4)
        Assert.assertNull(hashSearch[-4])

        hashSearch.remove(1)
        Assert.assertNull(hashSearch[1])
    }
}