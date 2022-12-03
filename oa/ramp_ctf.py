import numpy as np
f = open("word-list-7-letters.txt", "r")
chars = "abceilr"
chars_bi = [0] * 27
for i in range(7):
    # chars_bi ^= 1 << (ord(chars[i]) - ord('a') + 1)
    chars_bi[ord(chars[i]) - ord('a')] = 1
    # print(ord(chars[i]) - ord('a') + 1)
    # print(chars_bi)

for line in f.readlines():
    word_bi = [0] * 27
    for i in range(7):
        # word_bi ^= 1 << (ord(line[i]) - ord('a') + 1)
        if ord(line[i]) < ord('a') or ord(line[i]) > ord('z'):
            continue
        # print(ord(line[i]) - ord('a'))
        word_bi[ord(line[i]) - ord('a')] = 1
    if word_bi == chars_bi:
        print(line)
f.close()