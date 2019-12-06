/**
 * cse250.pa5.AVLTreeMap.scala
 *
 * Copyright 2019 Andrew Hughes (ahughes6@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 * Submission author
 * UBIT: garyfeng
 * Person#: 50242102
 *
 * Collaborators (include UBIT name of each, comma separated):
 * UBIT:
 */
package cse250.pa5

import cse250.objects.{AVLNode, Empty, Node}
import collection.mutable.Stack

class AVLTreeMap[K, V]()(implicit ord: Ordering[K]) extends cse250.objects.Map[K, V] {

  class AVLTree[K, V]()(implicit ord: Ordering[K]) {
    var avlRoot: AVLNode[(K, V)] = Empty

    def find(elem: K): AVLNode[(K, V)] = {
      var current = avlRoot
      var found = false
      while (!found && current != Empty) {
        val currentKey = current.value.get._1
        if (ord.lt(elem,currentKey)) current = current.left.get
        else if (ord.lt(currentKey,elem)) current = current.right.get
        else found = true
      }
      current
    }

    def rotateLeft(nodeA: AVLNode[(K, V)]): AVLNode[(K, V)] = ???

    def rotateRight(nodeA: AVLNode[(K, V)]): AVLNode[(K, V)] = ???

    def rotateLeftRight(nodeA: AVLNode[(K, V)]): AVLNode[(K, V)] = ???

    def rotateRightLeft(nodeA: AVLNode[(K, V)]): AVLNode[(K, V)] = ???

    def insert(elem: (K, V)): AVLNode[(K, V)] = ???

    def iterator: Iterator[(K, V)] = new Iterator[(K, V)] {
      val parentStack = {
        val stack = new Stack[AVLNode[(K, V)]]
        var currentNode = avlRoot
        while (currentNode != Empty) {
          stack.push(currentNode)
          currentNode = currentNode.left.get
        }
        stack
      }

      override def hasNext: Boolean = parentStack.nonEmpty

      override def next(): (K, V) = {
        val originalTop = parentStack.top
        if (originalTop.right.get != Empty) {
          var currentNode = parentStack.top.right.get
          while (currentNode != Empty) {
            parentStack.push(currentNode)
            currentNode = currentNode.left.get
          }
        }
        else {
          var recentTop = parentStack.pop
          while (parentStack.nonEmpty && recentTop != parentStack.top.left.get) {
            recentTop = parentStack.pop
          }
        }
        originalTop.value.get
      }
    }
  }

  val storageTree = new AVLTree[K, V]

  override def addOne(elem: (K, V)): Unit = storageTree.insert(elem)

  override def get(key: K): Option[V] = storageTree.find(key) match {
    case Empty => None
    case n: Node[(K, V)] => Some(n.v._2)
  }

  override def iterator: Iterator[(K, V)] = storageTree.iterator
}
