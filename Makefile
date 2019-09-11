all: janus.class


janus.class: src/janus.java src/janusParser.java src/janusDecFun.java src/genereteCode.java src/janusWriteF.java src/janusWriteB.java src/janusExpWalker.java src/janusIfThenElseWalker.java src/janusLoopWalker.java src/forkDecProgram.java src/janusForkandjoinWalker.java src/forkInitForward.java src/forkInitReverse.java src/janusStructDeclare.java src/threadJoin.java src/JanusHelp.java
	        javac src/*.java
