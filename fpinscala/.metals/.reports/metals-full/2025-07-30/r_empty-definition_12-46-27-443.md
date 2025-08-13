error id: file://<WORKSPACE>/src/test/scala/Ch7Spec.scala:`<none>`.
file://<WORKSPACE>/src/test/scala/Ch7Spec.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Par.
	 -scala/Predef.Par.
offset: 254
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
        assertEquals(@@Par.run(es)(p).get(), 10)
    }

    test("map should apply function inside Par") {
        val p = map(unit(10))(_ * 2)
        assertEquals()
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.