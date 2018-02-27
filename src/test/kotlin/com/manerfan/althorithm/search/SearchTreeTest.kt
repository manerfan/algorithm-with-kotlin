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
}