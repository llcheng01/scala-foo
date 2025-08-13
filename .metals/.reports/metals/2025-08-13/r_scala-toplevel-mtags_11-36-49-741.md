error id: file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala:[404..405) in Input.VirtualFile("file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala", "package fpinscala

object Ch8 {
    /**
      * forAll takes a function as parameter, and creates property
      * out of it that can be tested with the `check` method. 
      * The function should return `Boolean` or another property, 
      * and can take parameters of any types as long as there 
      * exist implicit `Arbitrary` instances for the types. 
      */
    trait Prop {
        def 
    }

    object Prop {
        def forAll[A](gen: Gen[A])(f: A => Boolean): Prop = ???
    }

    object Gen {
        def unit[A](a: => A): Gen[A] = ???
    }

    trait Gen[A] {
        def map[A, B](f: A => B): Gen[B] = ???
        def flatMap[A, B](f: A => Gen[B]): Gen[B] = ???
    }

    trait SGen[+A] {

    }

}
")
file://<WORKSPACE>/file:<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala
file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala:13: error: expected identifier; obtained rbrace
    }
    ^
#### Short summary: 

expected identifier; obtained rbrace