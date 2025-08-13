package fpinscala

object Ch8 {
    /**
      * forAll takes a function as parameter, and creates property
      * out of it that can be tested with the `check` method. 
      * The function should return `Boolean` or another property, 
      * and can take parameters of any types as long as there 
      * exist implicit `Arbitrary` instances for the types. 
      */
    trait Prop {
        def check: Boolean
        // 8.3
        def &&(p: Prop): Prop = Prop {
            def check = Prop.this.check && p.check
        }
        
        def check1: Either[(Prop.FailedCase, Prop.SuccessCount), Prop.SuccessCount]

        def &&1(p: Prop): Prop = Prop {
            def check1: Either[(Prop.FailedCase, Prop.SuccessCount), Prop.SuccessCount] = 
                Prop.this.check1 match {
                    case Left(fail) => Left(fail)
                    case Right(countA) => 
                        p.check1 match {
                            case Left(fail) => Left(fail)
                            case Right(countB) =>
                                Right(math.min(countA, countB)) 
                        }
                }
        }
    }

    object Prop {
        type FailedCase = String
        type SuccessCount = Int

        def forAll[A](gen: Gen[A])(f: A => Boolean): Prop = ???
    }

    trait Gen[A] {
        def generate(): List[A]


        def map[B](f: A => B): Gen[B] = ???
        def flatMap[B](f: A => Gen[B]): Gen[B] = ???
    }

    object Gen {
        def choose(start: Int, stopExclusive: Int): Gen[Int] = Gen[A] {
            def generate(): List[Int] = (start until stopExclusive).toList
        }

        def unit[A](a: => A): Gen[A] = Gen[A] {
            def generate(): List[A] = List(a)
        }

        def boolean: Gen[Boolean] = new Gen[Boolean] {
            def generate(): List[Boolean] = List(true, false)
        }

        def listOfN[A](n: Int, g: Gen[A]): Gen[List[A]] =
            Gen[List[A]] {
                def generate(): List[List[A]] = {
                @annotation.tailrec
                def loop(k: Int, acc: List[List[A]]): List[List[A]] =
                    if (k == 0) acc
                    else {
                    val xs = g.generate()
                    val next = xs.flatMap(a => acc.map(l => a :: l))
                    loop(k - 1, next)
                    }

                loop(n, List(Nil))
                }
            }

    }

    

    trait SGen[+A] {

    }

}
