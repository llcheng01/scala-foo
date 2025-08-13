file://<WORKSPACE>/src/test/scala/Ch7Spec.scala
### java.lang.IndexOutOfBoundsException: -1

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 266
uri: file://<WORKSPACE>/src/test/scala/Ch7Spec.scala
text:
```scala
package fpinscala

import munit.FunSuite
import java.util.concurrent.Executor

class Ch7Spec extends FunSuite {
  
    val es = Executor.newFixedThreadPool(4)

    test("unit should wrap value into a Par") {
        val p = unit(10)
        assertEquals(Par.run(es)(@@))
    }

}

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:129)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:244)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:101)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:46)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:435)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1