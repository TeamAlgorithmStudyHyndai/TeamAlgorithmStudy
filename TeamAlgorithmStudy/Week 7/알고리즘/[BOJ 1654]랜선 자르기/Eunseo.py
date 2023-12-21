import sys
input=sys.stdin.readline

k,n = map(int, input().strip().split())
lan = []
for i in range(k):
  lan.append(int(input().strip()))

left = 0
right = max(lan)

while left <= right :
  middle = (left+right)//2
  if middle ==0:
    right = 1
    break
  num = 0
  for i in lan:
    num += (i // middle)
  if num < n:
    right = middle - 1
  else :
    left = middle + 1

print (right)
