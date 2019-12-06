/**
 * cse250.objects.Map.scala
 *
 * Copyright 2019 Andrew Hughes (ahughes6@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 * DO NOT MODIFY THIS FILE
 */
package cse250.objects

trait Map[K,V] {
  def addOne(elem: (K,V)): Unit
  
  def get(key: K): Option[V]
  
  def contains(key: K) = get(key).isDefined
  
  def iterator: Iterator[(K,V)]
}