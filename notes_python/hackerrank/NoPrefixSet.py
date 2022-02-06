#!/bin/python3

import math
import os
import random
import re
import sys
from typing import List

#
# Complete the 'noPrefix' function below.
#
# The function accepts STRING_ARRAY words as parameter.
#

def noPrefix(words: List[str]):
    for i, w in enumerate(words):
        for i0 in range(i):
            if w.startswith(words[i0]):
                print("BAD SET")
                print(w)
                return
    print("GOOD SET")
    return


if __name__ == '__main__':
    n = int(input().strip())
    words = []

    for _ in range(n):
        words_item = input().strip()
        words.append(words_item)

    noPrefix(words)
