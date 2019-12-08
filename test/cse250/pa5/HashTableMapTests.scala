/**
 * cse250.pa4.TreeUtilitiesTest.scala
 *
 * Copyright 2019 Andrew Hughes (ahughes6@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 * Submission author
 * UBIT:
 * Person#:
 *
 * Collaborators (include UBIT name of each, comma separated):
 * UBIT:
 */

package cse250.pa5

import org.scalatest.FlatSpec

class HashTableMapTests extends FlatSpec {
  val testSize = 10
  val inputKeys = Array.tabulate(testSize)(i => i + 1)
  val inputValues = Array.tabulate(testSize)(i => i.toString * i)
  behavior of "insert"
  it should "add the (key,value) pairs" in {
    val hashMap = new HashTableMap[Int, String]
    val elements = inputKeys.zip(inputValues)
    for ((k, v) <- elements) {
      hashMap.addOne((k, v))
      assert(hashMap.contains(k))
    }
//    val iterator = hashMap.iterator
//    val elementSet = collection.mutable.Set[(Int, String)]()
//    for (_ <- elements.indices) {
//      assert(iterator.hasNext)
//      val elem = iterator.next
//      elementSet.add(elem)
//    }
//    for (i <- elements.indices) {
//      val elem = elements(i)
//      assert(elementSet.contains(elem))
//    }
  }
}

