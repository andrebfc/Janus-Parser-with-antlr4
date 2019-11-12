#! /bin/bash

echo $1 $2 $3 $4

exec java -cp :/usr/local/lib/antlr-4.7.1-complete.jar:./src janus $1 $2 $3 $4
