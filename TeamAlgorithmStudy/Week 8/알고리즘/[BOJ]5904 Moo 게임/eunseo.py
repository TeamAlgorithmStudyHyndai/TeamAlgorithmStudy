import sys
input=sys.stdin.readline

n = int(input())
S = "moo"

def find_Moo(idx, len, n):
  length = len * 2 + idx + 3
  if n <= 3:
    print(S[n-1])
    return
  if length < n :
    find_Moo(idx + 1, length, n)
  elif len + 1 == n :
    print("m") 
    return
  elif len + 1 < n <= len + idx + 3 :
    print("o")
    return
  else:
    find_Moo(1, 3, n - (len + idx + 3))

if n <= 3:
  print(S[n-1])
else : 
  find_Moo(1,3,n)
