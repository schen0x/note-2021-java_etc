import re
text_to_search = '''
acd-efg
bCd-efg
1234567
AEBCD_EFG
'''

pattern = re.compile(r'(a|b)[cC](d)', re.IGNORECASE)
matches = pattern.finditer(text_to_search)
for match in matches:
    print(match)
    # print(dir(match))
    print(match.group(0)) # 0 for all.

print()
print(pattern.sub(r'\1 | \2', text_to_search))
matches = pattern.finditer(text_to_search)
print(pattern.findall(text_to_search))

print('abc'.__class__)