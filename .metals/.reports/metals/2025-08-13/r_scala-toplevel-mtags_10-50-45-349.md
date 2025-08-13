error id: file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala:[287..288) in Input.VirtualFile("file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala", "package fpinscala

object Ch8 {
    trait Prop {

    }

    object Prop {
        def forAll[A](gen: Gen[A])(f: A => Boolean): Prop = ???
    }

    trait Gen[A] {
        def map[A, B](f: A => B): Gen[B] = ???
        def flatMap[A, B](f: A => Gen[B]): Gen[B] = ???
    }

    trait 

}
")
file://<WORKSPACE>/file:<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala
file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala:19: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace