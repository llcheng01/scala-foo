package fpinscala

object Ch3 {

    sealed trait LinkedList[+A] {
        def length: Int = 
            this match {
                case Nil => 0
                case Cons(_, tail) => 1 + tail.length 
            }
    }
    final case object Nil extends LinkedList[Nothing]
    // final case class End[+A]() extends LinkedList[A] 
    final case class Cons[+A](head: A, tail: LinkedList[A]) extends LinkedList[A] 

    object LinkedList {
        def sum(ints: LinkedList[Int]): Int = 
            ints match {
                case Nil => 0
                case Cons(head, tail) => head + sum(tail)
            }
        
        def product(ds: LinkedList[Double]): Double = 
            ds match {
                case Nil => 1.0
                case Cons(0.0, _) => 0.0
                case Cons(head, tail) => head * product(tail)
            }

        def apply[A](as: A*): LinkedList[A] =
            if (as.isEmpty) Nil
            else Cons(as.head, apply(as.tail: _*))

        // 3.2
        def tail[A](ll: LinkedList[A]): LinkedList[A] = 
            ll match {
                case Nil => throw new NoSuchElementException("cannot return tail of empty list")
                case Cons(_, tail) => tail
            }

        // 3.3
        def setHead[A](ll: LinkedList[A], h: A): LinkedList[A] = 
            ll match {
                case Nil => Cons(h, Nil)
                case Cons(_, tail) => Cons(h, tail) 
            }
        
        // 3.4
        def drop[A](ll: LinkedList[A], n: Int): LinkedList[A] = {
            if (n <= 0) ll
            else ll match {
                case Nil => Nil
                case Cons(_, t) => drop(t, n - 1) 
            }
        }

        // 3.5
        def dropWhile[A](ll: LinkedList[A], f: A => Boolean): LinkedList[A] = {
            ll match {
                case Nil => Nil
                case Cons(head, tail) if f(head) => { println("I am here"); dropWhile(tail, f) }
                case _ => ll
            }
        }

        // 3.6
        def init[A](ll: LinkedList[A]): LinkedList[A] = 
            ll match {
                case Nil => throw new NoSuchElementException("cannot return init of empty list")
                case Cons(_, Nil) => Nil 
                case Cons(head, tail) => Cons(head, init(tail))
            }

        def foldRight[A, B](as: LinkedList[A], z: B)(f: (A, B) => B): B = 
            as match {
                case Nil => z
                case Cons(head, tail) => f(head, foldRight(tail, z)(f))
            }

        // 3.7 Implement product using foldRight
        def sum2(ns: LinkedList[Int]) = 
            foldRight(ns, 0)((x, y) => x + y)

        def product2(ns: LinkedList[Double]) = 
            foldRight(ns, 1.0)(_ * _)

        // 3.8 

        // 3.9 Compute length of list using foldRight
        def lengthF[A](as: LinkedList[A]): Int = ???

        
             
    }
  
}
