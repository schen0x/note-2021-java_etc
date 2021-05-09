import requests
url = "127.0.0.1"
json = "{ a: 1, b: { c : 1}"
r2 = requests.post(url, json)

print(r2)