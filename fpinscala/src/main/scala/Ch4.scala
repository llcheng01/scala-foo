package fpinscala

import scala.{Option => _, Either => _}

object Ch4 {

  sealed trait MyOption[+A] {
    def map[B](f: A => B): MyOption[B] = this match {
      case MyNone    => MyNone
      case MySome(x) => MySome(f(x))
    }

    def flatMap[B](f: A => MyOption[B]): MyOption[B] =
      this.map(f).getOrElse(MyNone)

    def flatMap_1[B](f: A => MyOption[B]): MyOption[B] = this match {
      case MyNone        => MyNone
      case MySome(value) => f(value)
    }

    def getOrElse[B >: A](default: => B): B = this match {
      case MyNone        => default
      case MySome(value) => value
    }

    def orElse[B >: A](ob: => MyOption[B]): MyOption[B] = this match {
      case MyNone => ob
      case _      => this
    }

    def filter(f: A => Boolean): MyOption[A] = this match {
      case MySome(value) if f(value) => this
      case _                         => MyNone
    }

  }

  case object MyNone extends MyOption[Nothing]
  case class MySome[+A](value: A) extends MyOption[A]

  object MyOption {

    def lift[C, B](f: C => B): MyOption[C] => MyOption[B] =
      _.map(f)

    def map2[A, B, C](a: MyOption[A], b: MyOption[B])(
        f: (A, B) => C): MyOption[C] =
      a.flatMap(aa => b.map(bb => f(aa, bb)))

    def sequence[A](a: List[MyOption[A]]): MyOption[List[A]] =
      a match {
        case Nil     => MySome(Nil)
        case x :: xs => x.flatMap(xx => sequence(xs).map(xx :: _))
      }

    def traverse[A, B](a: List[A])(f: A => MyOption[B]): MyOption[List[B]] =
      a match {
        case Nil => MySome(Nil)
        case x :: xs =>
          f(x).flatMap(xx => traverse(xs)(f).map(xx :: _)) // map to turn MyOption[List[B]]
      }

  }

  sealed trait MyEither[+E, +A] {
    def map[B](f: A => B): MyEither[E, B] =
      this match {
        case MyLeft(e)  => MyLeft(e)
        case MyRight(a) => MyRight(f(a))
      }
    // def flatMap[EE >: E, B](f: A => MyEither[EE, B]): MyEither[E, B]
    // def orElse[EE >: E,B >:A](b: => MyEither[EE, B]): MyEither[EE, B]
    // def map2[EE >: E, B, C](b: MyEither[EE, B])(f: (A, B) => C): MyEither[EE, C]
    // def filter(f: A => Boolean): Option[B]

    // def sequence[E, A](es: List[MyEither[E, A]]): MyEither[E, List[A]]
    // def traverse[E, A, B](as: List[A])(f: A => MyEither[E, B]): MyEither[E, List[B]]

  }
  case class MyLeft[+E](value: E) extends MyEither[E, Nothing]
  case class MyRight[+A](value: A) extends MyEither[Nothing, A]
}
