package fpinscala

import scala.math.Ordering

object Ch3Tree {

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  // 3.26
  def size[A](t: Tree[A]): Int = {
    // def loop(tt: Tree[A], acc: Int): Int = {
    //     tt match {
    //         case Leaf(_) => acc + 1
    //         case Branch(left, right) => loop(left, acc + 1) + loop(right, acc + 1)
    //     }
    // }
    // loop(t, 0)

    t match {
      case Leaf(_)             => 1
      case Branch(left, right) => 1 + size(left) + size(right)
    }
  }

  object Tree {
    implicit def treeOrdering[A](implicit ord: Ordering[A]): Ordering[Tree[A]] =
      new Ordering[Tree[A]] {
        // compareTo
        def compare(x: Tree[A], y: Tree[A]): Int = (x, y) match {
          case (Leaf(a), Leaf(b))      => ord.compare(a, b)
          case (Leaf(_), Branch(_, _)) => -1
          case (Branch(_, _), Leaf(_)) => 1
          case (Branch(l1, r1), Branch(l2, r2)) =>
            val leftComp = compare(l1, l2)
            if (leftComp != 0) leftComp else compare(r1, r2)
        }
      }
  }

  // maximum returns maximum element in the Tree[Int]
  def maximum[A](t: Tree[A])(implicit ord: Ordering[A]): A = {
    t match {
      case Leaf(value) => value
      case Branch(left, right) =>
        val leftMax = maximum(left)
        val rightMax = maximum(right)
        // maximum(left) > maximum(right)
        if (implicitly[Ordering[A]].compare(leftMax, rightMax) > 0) leftMax
        else rightMax
    }
  }

  def map[A, B](fa: Tree[A])(f: (A) => B): Tree[B] =
    fa match {
      case Leaf(value)         => Leaf(f(value))
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
    }

  def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] =
    fa match {
      case Leaf(value)         => f(value)
      case Branch(left, right) => Branch(flatMap(left)(f), flatMap(right)(f))
    }

  def pure[A](a: A): Tree[A] =
    Leaf(a)

  // def depth[A](t: Tree[A]): Int =
  //     t match {
  //         case Leaf(_) => 1
  //         case Branch(left, right) => 1 + maximum(depth(left), depth(right))
  //     }

  // Breath First Search
  // def BFS(t: Tree[A]): Tree[A] = {
  // }
}
