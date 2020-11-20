# 1. extract all subdomain name. r'(?<=\/\/)((\w\.)+(\w)+)'
import re
import sys
from io import TextIOWrapper
ptn = re.compile(r'(?<=\/\/)(([\w0-9-]*\.)+(\w)+)')

tgt = '''
http://test.com
http://www.test2.com
http://www.test2.com
http://www.test2.com
http://www.test3.org
'''

# FIXME if(stdin)
# sysStdIn: TextIOWrapper = sys.stdin
dtIn = sys.stdin.read().encode('utf-8')
if (len(dtIn) > 0):
    tgt2 = dtIn
    print(tgt2)

rsraw = ptn.findall(tgt)
rs = set([r[0] for r in rsraw ])
print(*rs, sep='\n')