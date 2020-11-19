#!/bin/bash

awk '
BEGIN { print "Analysis of \"li\"" }
/\w\..*/  { ++n }
END   { print "\"li\" appears in", n, "records." }' testF
