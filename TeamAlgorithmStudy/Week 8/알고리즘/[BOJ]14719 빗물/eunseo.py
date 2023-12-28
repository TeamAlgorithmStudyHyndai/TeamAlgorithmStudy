import sys
import collections
input=sys.stdin.readline

h,w = map(int, input().split())
block = list(map(int, input().split()))

res = 0
height = collections.deque()
height.append(block[0])
if w > 1 : height.append(block[1])

for i in range(2,len(block)): 
  while len(height) > 0 and block[i] > height[-1] :
    bottom = height.pop()
    width = 1
    while len(height) > 0 and height[-1] == bottom:
      height.pop()
      width += 1
    if len(height) > 0 and height[-1] > bottom : #계속 숫자가 줄어드는 형태라면 물이 고일 수 없음
      res += width * (min(block[i], height[-1]) - bottom) #물 추가
      for cnt in range(width): height.append(min(block[i], height[-1])) #해당 너비만큼 물 높이 추가
  height.append(block[i])

print(res)
