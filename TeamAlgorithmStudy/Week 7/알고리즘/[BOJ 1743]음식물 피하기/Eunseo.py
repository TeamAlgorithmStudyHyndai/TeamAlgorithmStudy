import sys
import collections
input=sys.stdin.readline

n,m,k = map(int, input().strip().split())

trash = [[0] * m for _ in range(n)]
dx=[0,0,1,-1]
dy=[-1,1,0,0]
while k != 0 :
  x,y = map(int,input().strip().split())
  trash[x - 1][y - 1] = 1
  k -= 1

dq = collections.deque()
def bfs(x,y):
  dq.append([x,y])
  cnt = 0
  trash[x][y] = 0
  while dq:
    xxyy = dq.popleft()
    xx = xxyy[0]
    yy = xxyy[1]
    cnt += 1
    for i in range(4) :
      nx = xx + dx[i]
      ny = yy + dy[i]
      if 0 <= nx < n and 0 <= ny < m and trash[nx][ny] == 1 :
        dq.append([nx,ny])
        trash[nx][ny] = 0
  return cnt

res = 0
for i in range(n):
  for j in range(m):
    if trash[i][j] == 1 :
      res = max(res, bfs(i,j))

print(res)
