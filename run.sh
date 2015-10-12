# /usr/bin/bash

`pwd`/build.sh & build=$!

wait $build
`pwd`/exec.sh &
