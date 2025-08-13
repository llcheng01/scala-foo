error id: F35B2C474320C34D0633F9E8619E70FC
file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
### scala.reflect.internal.FatalError: 
  ThisType(method map2) for sym which is not a class
     while compiling: file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
        during phase: globalPhase=<no phase>, enteringPhase=parser
     library version: version 2.12.18
    compiler version: version 2.12.18
  reconstructed args: -deprecation -encoding utf-8 -explaintypes -feature -unchecked -Xfatal-warnings -Wconf:cat=unchecked:w -Wconf:cat=feature:w -Wconf:cat=deprecation:w -Wconf:cat=deprecation:ws -Wconf:cat=feature:ws -Wconf:cat=optimizer:ws -Ywarn-dead-code -Ywarn-value-discard -Ywarn-numeric-widen -Ywarn-unused:imports -Ywarn-unused:patvars -Ywarn-unused:privates -Ywarn-unused:locals -Ywarn-unused:explicits -Ywarn-unused:implicits -Ywarn-extra-implicit -Xlint:adapted-args -Xlint:nullary-unit -Xlint:inaccessible -Xlint:nullary-override -Xlint:infer-any -Xlint:missing-interpolator -Xlint:doc-detached -Xlint:private-shadow -Xlint:type-parameter-shadow -Xlint:poly-implicit-overload -Xlint:option-implicit -Xlint:delayedinit-select -Xlint:by-name-right-associative -Xlint:package-object-classes -Xlint:unsound-match -Xlint:stars-align -Xlint:constant -Ywarn-nullary-unit -Ywarn-nullary-override -classpath <WORKSPACE>/fpinscala/target/scala-2.12/classes:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/scala-lang/scala-library/2.12.18/scala-library-2.12.18.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-core_2.12/2.1.0/cats-core_2.12-2.1.0.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-effect_2.12/2.1.1/cats-effect_2.12-2.1.1.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/com/sourcegraph/semanticdb-javac/0.8.15/semanticdb-javac-0.8.15.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-macros_2.12/2.1.0/cats-macros_2.12-2.1.0.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-kernel_2.12/2.1.0/cats-kernel_2.12-2.1.0.jar -language:implicitConversions -language:higherKinds -language:existentials -language:experimental.macros -Xcheckinit -Yno-adapted-args -Yrangepos -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypartial-unification -Ypresentation-any-thread

  last tree to typer: TypeTree
       tree position: line 40 of file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
            tree tpe: <error>
              symbol: <none>
   symbol definition: <none> (a NoSymbol)
      symbol package: <none>
       symbol owners: 
           call site: <none> in <none>

== Source file context for tree position ==

    37         
    38       }
    39         val af = a(es)
    40         val bf = _CURSOR_b(es)
    41 
    42 
    43     private case class UnitFuture[A](get: A) extends Future[A] {

occurred in the presentation compiler.



action parameters:
offset: 1190
uri: file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
text:
```scala
package fpinscala

import java.util.concurrent._

object Ch7 {

  // trait Par[+A] {
  //   def map[B](f: A => B): Par[B] = this match {
  //       case MapPar(par, g) => MapPar(par, g andThen f)
  //       case _ => MapPar(this, f)
  //   }
  // }

  // case class MapPar[A, +B](par: Par[A], f: A => B) extends Par[B]
  type Par[A] = ExecutorService => Future[A]

  object Par {
    
    // `unit` is represented as a function that returns a `UnitFuture`, which is a simple `
    // which is a simple implementation of `Future` that just wraps a constant value. 
    // It doesn't use the `ExecutorService` at all. It's always done and can't be cancelled. 
    // Its `get` method simply returns the value that we gave it.
    def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a) 

    def fork[A](a: => Par[A]): Par[A] =
      es => es.submit(
        new Callable[A] {
          def call = a(es).get
        })

    def lazyUnit[A](a: => A): Par[A] = fork(unit(a))

    def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)

    def map2[A, B, C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] = 
      es => {
        
      }
        val af = a(es)
        val bf = @@b(es)


    private case class UnitFuture[A](get: A) extends Future[A] {
      def isDone = true
      def get(timeout: Long, units: TimeUnit) = get
      def isCancelled = false
      def cancel(evenIfRunning: Boolean): Boolean = false
    }
  
  
  }
  
}

object Examples {
  import Ch7.Par

  def sum(ints: IndexedSeq[Int]): Int = 
    if (ints.size <= 1)
      ints.headOption.getOrElse(0)
    else {
      val (l,r) = ints.splitAt(ints.length / 2)
      val sumL: Par[Int] = Par.lazyUnit(sum(l))
      val sumR: Par[Int] = Par.lazyUnit(sum(r))
      Par.run(es).get(sumL) + Par.get(sumR)
    }
}
```


presentation compiler configuration:
Scala version: 2.12.18
Classpath:
<WORKSPACE>/fpinscala/target/scala-2.12/classes [exists ], <HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/scala-lang/scala-library/2.12.18/scala-library-2.12.18.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-core_2.12/2.1.0/cats-core_2.12-2.1.0.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-effect_2.12/2.1.1/cats-effect_2.12-2.1.1.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/com/sourcegraph/semanticdb-javac/0.8.15/semanticdb-javac-0.8.15.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-macros_2.12/2.1.0/cats-macros_2.12-2.1.0.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-kernel_2.12/2.1.0/cats-kernel_2.12-2.1.0.jar [exists ]
Options:
-encoding utf-8 -deprecation -explaintypes -feature -language:existentials -language:experimental.macros -language:higherKinds -language:implicitConversions -unchecked -Xcheckinit -Xfatal-warnings -Xlint:adapted-args -Xlint:by-name-right-associative -Xlint:constant -Xlint:delayedinit-select -Xlint:doc-detached -Xlint:inaccessible -Xlint:infer-any -Xlint:missing-interpolator -Xlint:nullary-override -Xlint:nullary-unit -Xlint:option-implicit -Xlint:package-object-classes -Xlint:poly-implicit-overload -Xlint:private-shadow -Xlint:stars-align -Xlint:type-parameter-shadow -Xlint:unsound-match -Yno-adapted-args -Ywarn-dead-code -Ywarn-extra-implicit -Ywarn-nullary-override -Ywarn-nullary-unit -Ywarn-numeric-widen -Ywarn-unused:implicits -Ywarn-unused:imports -Ywarn-unused:locals -Ywarn-unused:params -Ywarn-unused:patvars -Ywarn-unused:privates -Ywarn-value-discard -Ypartial-unification -Yrangepos




#### Error stacktrace:

```
scala.reflect.internal.Reporting.abort(Reporting.scala:69)
	scala.reflect.internal.Reporting.abort$(Reporting.scala:65)
	scala.reflect.internal.SymbolTable.abort(SymbolTable.scala:28)
	scala.reflect.internal.Types$ThisType.<init>(Types.scala:1193)
	scala.reflect.internal.Types$UniqueThisType.<init>(Types.scala:1213)
	scala.reflect.internal.Types$ThisType$.apply(Types.scala:1217)
	scala.meta.internal.pc.AutoImportsProvider$$anonfun$1.applyOrElse(AutoImportsProvider.scala:89)
	scala.meta.internal.pc.AutoImportsProvider$$anonfun$1.applyOrElse(AutoImportsProvider.scala:74)
	scala.collection.immutable.List.collect(List.scala:315)
	scala.meta.internal.pc.AutoImportsProvider.autoImports(AutoImportsProvider.scala:74)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$autoImports$1(ScalaPresentationCompiler.scala:388)
	scala.meta.internal.pc.CompilerAccess.retryWithCleanCompiler(CompilerAccess.scala:182)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withSharedCompiler$1(CompilerAccess.scala:155)
	scala.Option.map(Option.scala:230)
	scala.meta.internal.pc.CompilerAccess.withSharedCompiler(CompilerAccess.scala:154)
	scala.meta.internal.pc.CompilerAccess.$anonfun$withInterruptableCompiler$1(CompilerAccess.scala:92)
	scala.meta.internal.pc.CompilerAccess.$anonfun$onCompilerJobQueue$1(CompilerAccess.scala:209)
	scala.meta.internal.pc.CompilerJobQueue$Job.run(CompilerJobQueue.scala:152)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:842)
```
#### Short summary: 

scala.reflect.internal.FatalError: 
  ThisType(method map2) for sym which is not a class
     while compiling: file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
        during phase: globalPhase=<no phase>, enteringPhase=parser
     library version: version 2.12.18
    compiler version: version 2.12.18
  reconstructed args: -deprecation -encoding utf-8 -explaintypes -feature -unchecked -Xfatal-warnings -Wconf:cat=unchecked:w -Wconf:cat=feature:w -Wconf:cat=deprecation:w -Wconf:cat=deprecation:ws -Wconf:cat=feature:ws -Wconf:cat=optimizer:ws -Ywarn-dead-code -Ywarn-value-discard -Ywarn-numeric-widen -Ywarn-unused:imports -Ywarn-unused:patvars -Ywarn-unused:privates -Ywarn-unused:locals -Ywarn-unused:explicits -Ywarn-unused:implicits -Ywarn-extra-implicit -Xlint:adapted-args -Xlint:nullary-unit -Xlint:inaccessible -Xlint:nullary-override -Xlint:infer-any -Xlint:missing-interpolator -Xlint:doc-detached -Xlint:private-shadow -Xlint:type-parameter-shadow -Xlint:poly-implicit-overload -Xlint:option-implicit -Xlint:delayedinit-select -Xlint:by-name-right-associative -Xlint:package-object-classes -Xlint:unsound-match -Xlint:stars-align -Xlint:constant -Ywarn-nullary-unit -Ywarn-nullary-override -classpath <WORKSPACE>/fpinscala/target/scala-2.12/classes:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/scala-lang/scala-library/2.12.18/scala-library-2.12.18.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-core_2.12/2.1.0/cats-core_2.12-2.1.0.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-effect_2.12/2.1.1/cats-effect_2.12-2.1.1.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/com/sourcegraph/semanticdb-javac/0.8.15/semanticdb-javac-0.8.15.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-macros_2.12/2.1.0/cats-macros_2.12-2.1.0.jar:<HOME>/Library/Caches/Coursier/v1/https/artifactory.banno-tools.com/artifactory/libs-release/org/typelevel/cats-kernel_2.12/2.1.0/cats-kernel_2.12-2.1.0.jar -language:implicitConversions -language:higherKinds -language:existentials -language:experimental.macros -Xcheckinit -Yno-adapted-args -Yrangepos -Ymacro-expand:discard -Ycache-plugin-class-loader:last-modified -Ypartial-unification -Ypresentation-any-thread

  last tree to typer: TypeTree
       tree position: line 40 of file://<WORKSPACE>/fpinscala/src/main/scala/Ch7.scala
            tree tpe: <error>
              symbol: <none>
   symbol definition: <none> (a NoSymbol)
      symbol package: <none>
       symbol owners: 
           call site: <none> in <none>

== Source file context for tree position ==

    37         
    38       }
    39         val af = a(es)
    40         val bf = _CURSOR_b(es)
    41 
    42 
    43     private case class UnitFuture[A](get: A) extends Future[A] {