import sys # sys.argv
from io import TextIOWrapper
import base64 # built-in, standard base64 encoding decoding

class ut_EncodeFileToBase64:
    # file.readAsBinary() -> print(standard_Base64_str), high order encoding unaffected
    @staticmethod
    def readAsBinaryToBase64(fileName:str):
        with open(fileName, 'rb') as f:
            dt = f.read() # e.g. b'\xe3\x81\x93\n'
            print(dt)
            # print(base64.b64encode(dt))
        return

ut_EncodeFileToBase64.readAsBinaryToBase64(sys.argv[1])

# Usage: python3 ut_EncodeFileToBase64.py 'fileName'