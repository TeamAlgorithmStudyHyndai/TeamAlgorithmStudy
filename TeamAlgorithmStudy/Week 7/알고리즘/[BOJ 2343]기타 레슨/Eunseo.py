import sys
input=sys.stdin.readline

n,m = map(int, input().strip().split())
lecture = list(map(int, input().strip().split()))

if n <= m :
  print(max(lecture))
else :
  left = max(lecture)
  right = sum(lecture)

  while left <= right :
    middle = (left+right)//2
    minute = 0
    num = 1
    i = 0
    while i < len(lecture):
      if minute + lecture[i] <= middle:
        minute += lecture[i]
        i += 1
      else :
        num += 1
        minute = 0
    if num > m :
      left = middle + 1
    else :
      right = middle - 1  
  print (left)
