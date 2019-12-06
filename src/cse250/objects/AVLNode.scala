/**
 * cse250.objects.AVLNode.scala
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

// Based on: https://gist.github.com/dholbrook/2967371
trait AVLNode[+A] {
  def value: Option[A] = this match {
    case n: Node[A] => Some(n.v)
    case Empty      => None
  }

  def left: Option[AVLNode[A]] = this match {
    case n: Node[A] => Some(n.l)
    case Empty      => None
  }

  def right: Option[AVLNode[A]] = this match {
    case n: Node[A] => Some(n.r)
    case Empty      => None
  }
  
  def parent: Option[AVLNode[A]] = this match {
    case n: Node[A] => Some(n.p)
    case Empty      => None
  }
  
  def leftHeavy: Option[Boolean] = this match {
    case n: Node[A] => Some(n.leftH)
    case Empty      => None
  }
  
  def rightHeavy: Option[Boolean] = this match {
    case n: Node[A] => Some(n.rightH)
    case Empty      => None
  }
}

class Node[A](var v: A, var l: AVLNode[A], var r: AVLNode[A], var p: AVLNode[A],
              var leftH: Boolean, var rightH: Boolean) extends AVLNode[A]
case object Empty extends AVLNode[Nothing]
