import sys
input=sys.stdin.readline

n, m = map(int, input().split())
graph = []
dis=[[sys.maxsize for _ in range(n)] for _ in range(n)]

for i in range(m):
  graph.append(list(map(int, input().strip().split())))
for i in range(n):
  dis[i][i] = 0

for i in range(len(graph)):
  dis[graph[i][0]-1][graph[i][1]-1] = 1
  dis[graph[i][1]-1][graph[i][0]-1] = 1

for i in range(n):
  for j in range(n):
    for k in range(n):
      if dis[j][k] > dis[j][i] + dis[i][k]:
        dis[j][k] = dis[j][i] + dis[i][k]

answer={}
for i in range(n):
  answer[i + 1] = 0
  for j in range(n):
    answer[i + 1] += dis[i][j]


sorted_ans = sorted(answer.items(), key=lambda x:x[1])
print(sorted_ans[0][0])
