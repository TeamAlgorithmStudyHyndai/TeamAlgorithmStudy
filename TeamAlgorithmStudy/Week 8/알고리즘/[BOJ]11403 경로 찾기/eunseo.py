import sys
input=sys.stdin.readline

n = int(input())
graph = []
dis=[[sys.maxsize for _ in range(n)] for _ in range(n)]
for i in range(n):
  temp = list(map(int, input().strip().split()))
  for j in range(n):
    if temp[j] == 1: graph.append([i,j])

for i in range(len(graph)):
  dis[graph[i][0]][graph[i][1]] = 1

for i in range(n):
  for j in range(n):
    for k in range(n):
      if dis[j][k] > dis[j][i] + dis[i][k]:
        dis[j][k] = dis[j][i] + dis[i][k]

for i in range(n):
  for j in range(n):
    if dis[i][j] != sys.maxsize: print(1, end=" ")
    else : print(0, end=" ")
  print()
