import sys
import heapq
input = sys.stdin.readline
n = int(input())
m = int(input())
pq = []
node = [[] for _ in range(n+1)]
dis = [sys.maxsize for _ in range(n + 1)]
for i in range(m):
    start,end,cost = map(int, input().split())
    node[start].append((cost,start, end))

start, end = map(int, input().split())

dis[start] = 0
for x in node[start] :
    heapq.heappush(pq,x)

current = start
while pq:
    next = heapq.heappop(pq)
    ncost = next[0]
    nstart = next[1]
    nnode = next[2]
    if dis[nnode] > dis[nstart] + ncost : 
        dis[nnode] = dis[nstart] + ncost
        for x in node[nnode]:
            heapq.heappush(pq,x)

print(dis[end])
