/**
 * cse250.pa5.HashTableMap.scala
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

import scala.collection.mutable.ListBuffer
import scala.util.hashing.Hashing

class HashTableMap[K, V]()(implicit hash: Hashing[K]) extends cse250.objects.Map[K, V] {
  var n = 0
  var N = 10
  var alpha: Double = 0.0
  val alphaMax: Double = 0.6

  var bucketArray = Array.fill[ListBuffer[(K,V)]](N)(ListBuffer[(K,V)]())

  def rehash(newSize: Int): Unit = {
    if (newSize > N) {
      val oldBucketArray = bucketArray
      n = 0
      N = newSize
      bucketArray = Array.fill[ListBuffer[(K,V)]](N)(ListBuffer[(K,V)]())
      alpha = n / N
      for (bucket <- oldBucketArray; elem <- bucket) addOne(elem)
    }
  }

  override def addOne(elem: (K, V)): Unit = {
    val lookupIndex = hash.hash(elem._1) % N
    bucketArray(lookupIndex).prepend(elem)
    n += 1
  }

  override def get(key: K): Option[V] = {
    val lookupIndex = hash.hash(key) % N
    for (elem <- bucketArray(lookupIndex)) {
      if (elem._1 == key) return Some(elem._2)
    }
    None
  }

  override def iterator: Iterator[(K, V)] = new Iterator[(K,V)] {
    var bucketidx = 0
    var bucketsize = 0
    var currentbucketlocation = 0
    var lastElem = true
    var totalItered = 0
    while(bucketidx < bucketArray.size  && bucketArray(bucketidx).isEmpty){ //to find the 1t bucket that has something
      bucketidx += 1
    }
    var current = bucketArray(bucketidx)(currentbucketlocation)

    override def hasNext: Boolean = {
      currentbucketlocation += 1
      if (currentbucketlocation >= bucketArray(bucketidx).length){
        currentbucketlocation = 0
        bucketidx += 1
        while(bucketidx < bucketArray.size && bucketArray(bucketidx).isEmpty){ //to find the next bucket that has something
          bucketidx += 1
        }
      }
      lastElem
    }

    override def next(): (K,V) = {
      val previousNode = current
      current = bucketArray(bucketidx)(currentbucketlocation)
      totalItered += 1
      if (totalItered == n) {
        lastElem = false
        return current
      }
      previousNode
    }
  }
}
