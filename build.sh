# /usr/bin/bash

cd `expr $(pwd) : '\(.*app-comprar-passagens-aereas\)'`; find . -name '*.java' | xargs javac -d binary/
