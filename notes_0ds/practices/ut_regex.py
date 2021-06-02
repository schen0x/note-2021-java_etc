import re
text_to_search = '''
acd-efg
bCd-efg
1234567
AEBCD_EFG
'''

# simple match
print('\n=============start===============')
res = re.match("a\w+$", "abc")
print(res)
print(res.groups())
print('------')
# search vs match, match only check from the start.
print(re.match("b\w+$", "abc"))
print(re.search("b\w+$", "abc"))
print('------')
# with re.compile
pattern = re.compile(r'(a|b)[cC](d)', re.IGNORECASE)
matches = pattern.finditer(text_to_search)
for match in matches:
    print(match)
    # print(dir(match))
    print(match.group(0)) # 0 for all.

print('------')
print(pattern.sub(r'\1 | \2', text_to_search))
matches = pattern.finditer(text_to_search)
print(pattern.findall(text_to_search))
print('abc'.__class__)