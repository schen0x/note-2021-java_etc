import sys
from io import TextIOWrapper

class ut_EncodeStrToUTF8:
    # sys.stdin -> utf-8 string
    @staticmethod
    def readStrPrintUTF8(stdin:TextIOWrapper):
        print(stdin.read().encode('utf-8'))
        return

ut_EncodeStrToUTF8.readStrPrintUTF8(sys.stdin) 

# Usage: echo 'こ' | python3 ut_EncodeStrToUTF8.py