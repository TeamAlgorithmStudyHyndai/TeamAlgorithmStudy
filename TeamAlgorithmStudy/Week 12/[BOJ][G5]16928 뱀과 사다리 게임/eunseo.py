import sys
import collections
input = sys.stdin.readline

n,m = map(int, input().split())
arr = [0 for _ in range(100)]
for _ in range(n + m) :
    a, b = map(int, input().split())
    arr[a] = b

q = collections.deque()
q.append([1,0]) #현재좌표, res
res = sys.maxsize
check = [0 for _ in range(100)]
while q:
    xy = q.popleft()
    for i in range(1,7):
        x = xy[0] + i
        if x == 100:
            res = min(res, xy[1] + 1)
        elif x < 100 :
            if arr[x] != 0 : x = arr[x]
            if check[x] == 0 :
                q.append([x, xy[1] + 1])
                check[x] = 1
    
print(res)
