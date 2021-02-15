from Crypto.Cipher import AES

key = b'Sixteen byte key'
cipher = AES.new(key, AES.MODE_EAX)
data = b'abc'
nonce = cipher.nonce
ciphertext, tag = cipher.encrypt_and_digest(data)
print(nonce)
print(ciphertext)
print(tag)


key = b'Sixteen byte key'
cipher = AES.new(key, AES.MODE_EAX, nonce=nonce)
plaintext = cipher.decrypt(ciphertext)
try:
    cipher.verify(tag)
    print("The message is authentic:", plaintext)
except ValueError:
    print("Key incorrect or message corrupted")

print(plaintext)
