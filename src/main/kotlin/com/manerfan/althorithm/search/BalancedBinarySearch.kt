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
 * 平衡查找树
 * @author manerfan
 * @date 2018/2/28
 */

class BalancedBinarySearch<K : Comparable<K>, V> : BinarySearch<K, V>() {

    private fun isRed(node: Node<K, V>?) = node?.red ?: false
    private fun flipColors(node: Node<K, V>): Node<K, V> {
        node.red = true
        node.left?.red = false
        node.right?.red = false
        return node
    }

    private fun rotateLeft(node: Node<K, V>): Node<K, V> {
        var r = node.right!!
        node.right = r.left
        r.left = node
        r.red = node.red
        node.red = true
        return r
    }

    private fun rotateRight(node: Node<K, V>): Node<K, V> {
        var l = node.left!!
        node.left = l.right
        l.right = node
        l.red = node.red
        node.red = true
        return l
    }

    private fun put(node: Node<K, V>?, sub: Node<K, V>): Node<K, V> {
        node ?: return sub

        when {
            sub.key < node.key -> node.left = put(node.left, sub)
            sub.key > node.key -> node.right = put(node.right, sub)
            else -> node.value = sub.value
        }

        return when {
            !isRed(node.left) && isRed(node.right) -> rotateLeft(node)
            isRed(node.left) && isRed(node.left?.left) -> rotateRight(node)
            isRed(node.left) && isRed(node.left) -> flipColors(node)
            else -> node
        }
    }

    override fun put(key: K, value: V): V {
        tree = put(tree, Node(key, value))
        tree?.red = false
        return value
    }
}