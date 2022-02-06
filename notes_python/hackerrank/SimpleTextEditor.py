# Implement a simple text editor. The editor initially contains an empty string, . Perform  operations of the following  types:
#
# append - Append string  to the end of .
# delete - Delete the last  characters of .
# print - Print the  character of .
# undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
# Example
#
#
#
# operation
# index   S       ops[index]  explanation
# -----   ------  ----------  -----------
# 0       abcde   1 fg        append fg
# 1       abcdefg 3 6         print the 6th letter - f
# 2       abcdefg 2 5         delete the last 5 letters
# 3       ab      4           undo the last operation, index 2
# 4       abcdefg 3 7         print the 7th characgter - g
# 5       abcdefg 4           undo the last operation, index 0
# 6       abcde   3 4         print the 4th character - d
# The results should be printed as:
#
# f
# g
# d
# Input Format
#
# The first line contains an integer, , denoting the number of operations.
# Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line  will be 1 abcd.
#
# Constraints
#
# The sum of the lengths of all  in the input .
# The sum of  over all delete operations .
# All input characters are lowercase English letters.
# It is guaranteed that the sequence of operations given as input is possible to perform.
# Output Format
#
# Each operation of type  must print the  character on a new line.

import sys

history = []

def append(S: str, W: str) -> str:
    history.append(S)
    return S + W

def delete(S: str, K: str) -> str:
    k = int(K)
    history.append(S)
    return S[:-k]

def pt(S: str, K: str) -> None:
    k = int(K)
    if k < 1:
        return
    print(S[k-1:k])
    return

def undo() -> str:
    return history.pop()

if __name__ == "__main__":
    lines = []
    for line in sys.stdin:
        lines.append(line)
    lines = lines[1:]

    S = ""
    for line in lines:
        ls = line.split(" ")
        op = ls[0].strip()
        argv = ls[1].strip() if len(ls)> 1 else ""
        if op == "1":
            S = append(S, argv)
            continue
        if op == "2":
            S = delete(S, argv)
            continue
        if op == "3":
            pt(S, argv)
            continue
        if op == "4":
            S = undo()
