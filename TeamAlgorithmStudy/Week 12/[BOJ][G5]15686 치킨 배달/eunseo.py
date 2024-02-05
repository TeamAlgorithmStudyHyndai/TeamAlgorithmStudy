import sys
from itertools import combinations
input = sys.stdin.readline

n, m = map(int, input().split())

city = [ list(map(int,input().split())) for _ in range(n)]
chicken = []
home = []
def dis(i,j,x,y):
    return abs(i-x) + abs(j - y)

for i in range(n):
    for j in range(n):
        if city[i][j] == 2 : chicken.append([i,j])
        if city[i][j] == 1 : home.append([i,j])
        
comb = list(combinations(chicken, m))

res = sys.maxsize

for cmb in comb:
    tmp = 0
    for h in home :
        temp = sys.maxsize
        for idx in range(m):
            temp = min(temp, dis(h[0],h[1],cmb[idx][0],cmb[idx][1]))
        tmp += temp
    res = min(res, tmp)

print(res)
