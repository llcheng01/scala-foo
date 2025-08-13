file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala
### java.lang.IndexOutOfBoundsException: -1

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 709
uri: file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala
text:
```scala
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
    }

    object Prop {
        def forAll[A](gen: Gen[A])(f: A => Boolean): Prop = ???
    }

    object Gen {
        def choose(start: Int, stopExclusive: Int): Gen[Int] = Gen[@@]

        def unit[A](a: => A): Gen[A] = ???
    }

    trait Gen[A] {
        def map[A, B](f: A => B): Gen[B] = ???
        def flatMap[A, B](f: A => Gen[B]): Gen[B] = ???
    }

    trait SGen[+A] {

    }

}

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:129)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:244)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:104)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:46)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:435)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1