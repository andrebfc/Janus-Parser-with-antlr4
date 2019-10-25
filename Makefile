all: janus.class

janus.class: src/janus.java src/janusParser.java src/janusDecFun.java src/genereteCode.java src/janusWriteF.java src/janusWriteB.java src/janusExpWalker.java src/janusIfThenElseWalker.java src/janusLoopWalker.java src/forkDecProgram.java src/janusForkandjoinWalker.java src/forkInitForward.java src/forkInitReverse.java src/janusStructDeclare.java  src/JanusHelp.java src/utility.java src/janusRules.java
				javac ./src/*.java

