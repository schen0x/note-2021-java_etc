#!/bin/bash -x

echo "$( echo "$( echo hi )" )"

var1=1
echo $var1
var2=2
echo $var2

$(var1=11)
echo $var1
`var2=22`
echo $var2

`echo ls` # equivalent to `ls`