import sys # for sys.argv
import base64 # built-in, standard base64 encoding decoding
import codecs # built-in, legacy?

class v2encdec:
    # take sys.argv[1] as fileName
    # fileName: a suitable input for open()
    @staticmethod
    def readAsBinaryToBase64(fileName:str):
        with open(fileName, 'rb') as f:
            dt = f.read() #read all
            out = base64.b64encode(dt)
            print(out)
        return

    # take sys.argv[1] as fileName
    # fileName: a suitable input for open()
    # output base64 encoded result with \n
    @staticmethod
    @DeprecationWarning
    def readAsBinaryToBase64_withLineBreak(fileName):
        with open(fileName, 'rb') as f:
            dt = f.read() #read all
            out = codecs.encode(dt, encoding="base64")
            print(out)

v2encdec.readAsBinaryToBase64(sys.argv[1])