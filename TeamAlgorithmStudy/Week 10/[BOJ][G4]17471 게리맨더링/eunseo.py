import sys,itertools, collections
import copy
input = sys.stdin.readline

def bfs(same):
    start = same[0]
    q = collections.deque([start])
    visited = set([start])
    sum = 0
    while q:
        v = q.popleft()
        sum += pp[v]
        for u in g[v]:
            if u not in visited and u in same:
                q.append(u)
                visited.add(u)
    return sum, len(visited)

n = int(input().strip())
pp = [int(x) for x in input().split()]
g = collections.defaultdict(list)
result = sys.maxsize

for i in range(n):
    tmp = [int(x) for x in input().split()]
    for j in range(1, tmp[0]+1):
        g[i].append(tmp[j]-1)

for i in range(1, n // 2 + 1):
    combis = list(itertools.combinations(range(n), i))
    for combi in combis:
        sum1, v1 = bfs(combi)
        sum2, v2 = bfs([i for i in range(n) if i not in combi])
        if v1 + v2 == n: 
            result = min(result, abs(sum1 - sum2))

if result != sys.maxsize: print(result)
else: print(-1)
