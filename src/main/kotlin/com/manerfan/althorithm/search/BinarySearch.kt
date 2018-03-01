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
 * 二叉查找树
 * @author manerfan
 * @date 2018/2/27
 */

open class BinarySearch<K : Comparable<K>, V> : Search<K, V>() {
    protected var tree: Node<K, V>? = null

    private fun put(node: Node<K, V>?, sub: Node<K, V>): Node<K, V> {
        return when (node) {
            null -> {
                size++
                sub
            }
            else -> {
                when {
                    node.key < sub.key -> node.right = put(node.right, sub) // 左
                    node.key > sub.key -> node.left = put(node.left, sub) // 右
                    else -> node.value = sub.value // 已存在
                }
                node
            }
        }
    }

    override fun put(key: K, value: V): V {
        tree = put(tree, Node(key, value))
        return value
    }

    private fun min(node: Node<K, V>?): Node<K, V>? {
        node ?: return null

        return when (node.left) {
            null -> node
            else -> min(node.left)
        }
    }

    private fun removeMin(node: Node<K, V>?): Node<K, V>? {
        node ?: return null
        return when (node.left) {
            null -> node.right // 将最小节点的右子树赋给父节点左子树
            else -> {
                node.left = removeMin(node.left)
                node
            }
        }
    }

    private fun remove(node: Node<K, V>?, key: K): Node<K, V>? {
        node ?: return null
        when {
            node.key < key -> node.right = remove(node.right, key) // 右侧
            node.key > key -> node.left = remove(node.left, key) // 左侧
            else -> { // 找到
                return when {
                    node.left == null -> node.right // 左子树为空
                    node.right == null -> node.left // 右子树为空
                    else -> { // 将右子树最小节点提升为待删除节点位置
                        var rightMin = min(node.right)
                        rightMin?.right = removeMin(node.right)
                        rightMin?.left = node.left
                        rightMin
                    }
                }
            }
        }
        return node
    }

    override fun remove(key: Any?): V? {
        tree = remove(tree, key as K)
        return tree?.value
    }

    private fun get(node: Node<K, V>?, key: K): Node<K, V>? {
        node ?: return null

        return when {
            node.key < key -> get(node.right, key)
            node.key > key -> get(node.left, key)
            else -> node
        }
    }

    override fun get(key: Any?) = get(tree, key as K)?.value

}