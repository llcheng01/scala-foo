file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala
### java.lang.AssertionError: assertion failed

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/fpinscala/src/main/scala/Ch8.scala
text:
```scala
package fpinscala

object Ch8 {
    trait Prop {

    }

    object Prop {
        def forAll[A](gen: Gen[A])(f"")
    }

}

```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:11)
	dotty.tools.dotc.parsing.Scanners$Scanner.lookahead(Scanners.scala:1093)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause$$anonfun$1(Parsers.scala:3418)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosedWithCommas(Parsers.scala:589)
	dotty.tools.dotc.parsing.Parsers$Parser.inParensWithCommas(Parsers.scala:602)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause(Parsers.scala:3434)
	dotty.tools.dotc.parsing.Parsers$Parser.recur$6(Parsers.scala:3448)
	dotty.tools.dotc.parsing.Parsers$Parser.recur$6(Parsers.scala:3452)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClauses(Parsers.scala:3456)
	dotty.tools.dotc.parsing.Parsers$Parser.defDefOrDcl(Parsers.scala:3747)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3636)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq$$anonfun$1(Parsers.scala:4311)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:524)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq(Parsers.scala:4319)
	dotty.tools.dotc.parsing.Parsers$Parser.$anonfun$40(Parsers.scala:4194)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:580)
	dotty.tools.dotc.parsing.Parsers$Parser.inBraces(Parsers.scala:599)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:613)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:616)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBody(Parsers.scala:4194)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBodyOpt(Parsers.scala:4187)
	dotty.tools.dotc.parsing.Parsers$Parser.template(Parsers.scala:4164)
	dotty.tools.dotc.parsing.Parsers$Parser.templateOpt(Parsers.scala:4176)
	dotty.tools.dotc.parsing.Parsers$Parser.objectDef(Parsers.scala:3908)
	dotty.tools.dotc.parsing.Parsers$Parser.tmplDef(Parsers.scala:3862)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3642)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq$$anonfun$1(Parsers.scala:4311)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:524)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq(Parsers.scala:4319)
	dotty.tools.dotc.parsing.Parsers$Parser.$anonfun$40(Parsers.scala:4194)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:580)
	dotty.tools.dotc.parsing.Parsers$Parser.inBraces(Parsers.scala:599)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:613)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:616)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBody(Parsers.scala:4194)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBodyOpt(Parsers.scala:4187)
	dotty.tools.dotc.parsing.Parsers$Parser.template(Parsers.scala:4164)
	dotty.tools.dotc.parsing.Parsers$Parser.templateOpt(Parsers.scala:4176)
	dotty.tools.dotc.parsing.Parsers$Parser.objectDef(Parsers.scala:3908)
	dotty.tools.dotc.parsing.Parsers$Parser.tmplDef(Parsers.scala:3862)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3642)
	dotty.tools.dotc.parsing.Parsers$Parser.topStatSeq(Parsers.scala:4251)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4445)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4439)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit$$anonfun$1(Parsers.scala:4450)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:524)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit(Parsers.scala:4455)
	dotty.tools.dotc.parsing.Parsers$Parser.parse(Parsers.scala:197)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:32)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:467)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:40)
	dotty.tools.dotc.parsing.Parser.$anonfun$2(ParserPhase.scala:52)
	scala.collection.Iterator$$anon$6.hasNext(Iterator.scala:479)
	scala.collection.Iterator$$anon$9.hasNext(Iterator.scala:583)
	scala.collection.immutable.List.prependedAll(List.scala:152)
	scala.collection.immutable.List$.from(List.scala:685)
	scala.collection.immutable.List$.from(List.scala:682)
	scala.collection.IterableOps$WithFilter.map(Iterable.scala:900)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:51)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:315)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1324)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:308)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:348)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:357)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
	dotty.tools.dotc.Run.compileUnits(Run.scala:357)
	dotty.tools.dotc.Run.compileSources(Run.scala:261)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:161)
	dotty.tools.pc.CachingDriver.run(CachingDriver.scala:45)
	dotty.tools.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:31)
	dotty.tools.pc.SimpleCollector.<init>(PcCollector.scala:351)
	dotty.tools.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:88)
	dotty.tools.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:111)
```
#### Short summary: 

java.lang.AssertionError: assertion failed