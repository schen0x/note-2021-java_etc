#!/bin/bash -x

echo "$( echo "$( echo hi )" )"

echo "main" | xargs echo
echo "main" | echo "?"