import sys
input=sys.stdin.readline

n, m = map(int, input().split())
graph = [[0 for _ in range(n)] for _ in range(n)]
dis=[[sys.maxsize for _ in range(n)] for _ in range(n)]

for i in range(n):
  dis[i][i] = 0
  temp = list(map(int, input().split()))
  for j in range(len(temp)):
    dis[i][j] = temp[j]
    #graph[i][j] = temp[j]


for k in range(n):
  for i in range(n):
    for j in range(n):
      if dis[i][j] > dis[i][k] + dis[k][j]:
        dis[i][j] = dis[i][k] + dis[k][j]

for i in range(m):
  a,b,c = map(int, input().split())
  if dis[a-1][b-1] <= c:
    print("Enjoy other party")
  else: print("Stay here")
