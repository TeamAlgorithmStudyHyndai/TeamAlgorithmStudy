import sys
import collections
input=sys.stdin.readline

n,m = map(int, input().strip().split())
cheese = []
visited =[[0] * m for _ in range(n)]

for i in range(n):
  cheese_line = list(map(int,input().strip().split()))
  cheese.append(cheese_line)

# 0,0 (->무조건 치즈 없음) / 이전 단계 테두리 부터 상하좌우 4방향 탐색해서 있는 치즈는 테두리임. 
#대각선 탐색하지 않으므로 치즈 내부의 구멍은 탐색 X 
  
move=[[0,1],[0,-1],[1,0],[-1,0]]  
def isIn(x,y):
  if 0<=x<n and 0<=y<m:
    return True
  else:
    return False
  
def findBorder(start_x,start_y) :
  q = collections.deque()
  q.append([start_x,start_y])
  num_of_border= 0
  while q:
    xy = q.popleft()
    x = xy[0]
    y = xy[1]
    for i in move:
      xx = x + i[0]
      yy = y + i[1]
      if isIn(xx,yy) and cheese[xx][yy] == 1 and visited[xx][yy] == 0:
        visited[xx][yy] = 1
        cheese[xx][yy] = 0
        num_of_border += 1
      if isIn(xx,yy) and cheese[xx][yy] == 0 and visited[xx][yy] == 0:
        visited[xx][yy] = 1
        q.append([xx,yy])
  return num_of_border

hour = 0
res = findBorder(0,0)
while res != 0:
  hour += 1
  visited =[[0] * m for _ in range(n)]
  before_res = res
  res = findBorder(0,0)

print(hour)
print(before_res)
