# 1. extract all subdomain name. r'(?<=\/\/)((\w\.)+(\w)+)'
import re

tgt = "index.html"
pt = re.compile(
    r'(?<=\/\/)(([-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b)([-a-zA-Z0-9()@:%_\+.~#?&/=]*))')
######## example matches ##########
# play.google.com/?hl=ja&tab=w8
# schema.org/WebPage
# www.google.com/url?q=https://store.google.com/product/chromecast_google_tv%3Futm_source%3Dhpp%26utm_medium%3Dgoogle_oo%26utm_campaign%3DGS105832&amp

outList = []
# output group[1] only, e.g. play.google.com
with open(tgt, "rb") as f:
    ct = f.read()
    ct = ct.decode('utf-8')
    # matches = pt.finditer(ct)
    matches = pt.findall(ct)
    matches = sorted(matches, key=lambda x: x[1])
    seen = set()
    results = [seen.add(m[1]) or m[1] for m in matches if m[1] not in seen]
    for m in results:
        print(m)
        outList.append(m)

# write hosts to file for further inspection
outFileName = tgt.partition('.')[0] + '_hosts'
with open(outFileName, 'w') as f:
    for m in outList:
        f.write(m + '\n')

# then loop through the file in the shell:
# while read p; do host $p >> index_hosts_result; done < index_hosts

print('---------------------------------\n')
# print group[0]
with open(tgt, "rb") as f:
    ct = f.read()
    ct = ct.decode('utf-8')
    # matches = pt.finditer(ct)
    matches = pt.findall(ct)
    matches = sorted(matches, key=lambda x: x[1])
    seen = set()
    results = [seen.add(m[0]) or m[0] for m in matches if m[0] not in seen]
    for m in results:
        print(m)



###############################################
# extra debugging, grep a line contains match.
pt = re.compile(r'(?<=(\/\/))(\w*\.?\w*)+')
with open(tgt, "rb") as fl:
    lines = fl.readlines()
    print(len(lines))
    for line in lines:
        if(pt.search(ct)):
            print(line)
