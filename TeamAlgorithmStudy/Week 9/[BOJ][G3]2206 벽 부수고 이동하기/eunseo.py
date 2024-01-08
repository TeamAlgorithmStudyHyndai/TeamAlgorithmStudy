import sys
import collections
input=sys.stdin.readline

n, m = map(int, input().split())
wall = [list(input().strip()) for _ in range(n)]
check = [[[0 for _ in range(2)] for _ in range(m)] for _ in range(n)]

q = collections.deque()
q.append([0,0,0,1]) #x,y,벽 부순 개수, 이동거리
res = sys.maxsize
move = [[0,1],[0,-1],[1,0],[-1,0]]
while q:
  current = q.popleft()
  x = current[0]
  y = current[1]
  status = current[2]
  cnt = current[3]
  if x == n - 1 and y == m - 1 :
    res = min(res, cnt)
    continue
  for mv in move:
    xx = x + mv[0]
    yy = y + mv[1]
    if 0 <= xx < n and 0 <= yy < m:
      if status == 0:
        if wall[xx][yy] == '1':
          check[xx][yy][1] = 1
          q.append([xx,yy,1, cnt + 1])
        elif wall[xx][yy] == '0' and check[xx][yy][0] == 0:
          check[xx][yy][0] = 1
          check[xx][yy][1] = 1 #벽 부수기 이전에 지나온 길은 벽을 부순 후에도 갈 필요 X
          q.append([xx,yy,0,cnt + 1])
      elif status == 1:
        if wall[xx][yy] == '0' and check[xx][yy][1] == 0:
          check[xx][yy][1] = 1
          q.append([xx,yy,1,cnt + 1])

if res == sys.maxsize : print(-1)
else : print(res)
