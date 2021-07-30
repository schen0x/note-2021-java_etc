# extract all subdomain name from an [html] file.
# Usage: python3 ./ut_DempSubdomainFromFile.py ./index.html

import re

tgt = "index.html"
pt = re.compile(
    r'(?<=\/\/)(([-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b)([-a-zA-Z0-9()@:%_\+.~#?&/=]*))')

# example matches
# --------------------------------------------------------------------------------
# play.google.com/?hl=ja&tab=w8
# schema.org/WebPage
# www.google.com/url?q=https://store.google.com/product/chromecast_google_tv%3Futm_source%3Dhpp%26utm_medium%3Dgoogle_oo%26utm_campaign%3DGS105832&amp

# other regex options: r'(?<=\/\/)((\w\.)+(\w)+)'

# group 1 contains host part only. e.g. play.google.com
regex_match_g00 = []
regex_match_g01 = []
with open(tgt, "rb") as f:
    ct = f.read()
    ct = ct.decode('utf-8')
    # matches = pt.finditer(ct)
    matches = pt.findall(ct)
    matches = sorted(matches, key=lambda x: x[1])
    seen = set()

    res_g00 = [seen.add(m[0]) or m[0] for m in matches if m[0] not in seen]
    res_g01 = [seen.add(m[1]) or m[1] for m in matches if m[1] not in seen]
    for m in res_g00:
        print(m)
        regex_match_g00.append(m)
    print('---------------------------------\n')
    for m in res_g01:
        # print(m)
        regex_match_g01.append(m)

# write hosts to file for further inspection
outFileName = tgt.partition('.')[0] + '_hosts'
with open(outFileName, 'w') as f:
    for m in regex_match_g01:
        f.write(m + '\n')

# then loop through the file in the shell:
# while read p; do host $p >> index_hosts_result; done < index_hosts