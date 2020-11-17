#!/bin/bash
tCount=0
for t in {1,{10..60..10}}; do
    echo "t=$t tCount=$tCount"
    (( tCount++ ))
done 
