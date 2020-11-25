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

# grep matches
tgt="wikiMainPage.html"
pt = re.compile(r'(?<=(\/\/))(\w+\.?\w*)+')
with open("wikiMainPage.html", "rb") as f:
    ct = f.read()
    ct = ct.decode('utf-8')
    # matches = pt.finditer(ct)
    matches = pt.findall(ct)
    matches = sorted(matches.unique, key=lambda x: x[1])
    for m in matches:
        print(m)

# debugging method grep a line contains match.
pt = re.compile(r'(?<=(\/\/))(\w*\.?\w*)+')
with open(tgt, "rb") as fl:
    lines = fl.readlines()
    print(len(lines))
    for line in lines:
        if(pt.search(ct)):
            print(line)