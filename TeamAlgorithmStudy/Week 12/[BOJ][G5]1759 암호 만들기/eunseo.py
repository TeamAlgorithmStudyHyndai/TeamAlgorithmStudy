import sys
from itertools import combinations
input = sys.stdin.readline

l, c = map(int, input().split())
letter = list(map(str, input().split()))

a = [] #모음
b = [] #자음

check = []

for i in range(c):
    if letter[i] in ['a','e','i','o','u'] : a.append(letter[i])
    else : b.append(letter[i])

len_b = 2
len_a = l - len_b
while len_a >= 1 and len_b >= 2 : 
    temp = combinations(a,len_a)
    temp2 = list(combinations(b, len_b))
    for comb in temp:
        for comb2 in temp2 :
            temp3 = list(comb + comb2)
            temp3.sort()
            res = ""
            for idx in range(l):
                res += temp3[idx]
            check.append(res)
    len_a -= 1
    len_b += 1

check.sort()
for ans in check:
    print(ans)

