# 1. extract all subdomain name. r'(?<=\/\/)((\w\.)+(\w)+)'
import re
import sys
ptn = re.compile(r'(?<=\/\/)(([\w0-9-]*\.)+(\w)+)')

tgt = '''
http://test.com
http://www.test2.com
http://www.test2.com
http://www.test2.com
http://www.test3.org
'''

# FIXME if(stdin)
# if (sys.stdin):
    # tgt = sys.stdin

rsraw = ptn.findall(tgt)
rs = set([r[0] for r in rsraw ])

print(*rs, sep='\n')