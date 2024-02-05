import sys
import collections
input = sys.stdin.readline

r,c = map(int, input().split())
arr = [['.' for _ in range(c)]for _ in range(r)]

q = collections.deque()
d = [0,0]
s = collections.deque()

for i in range(r):
    line = input()
    for j in range(c):
        if line[j] == '*' : q.append([i,j])
        if line[j] == 'D' : d = [i,j]
        if line[j] == 'S' : s.append([i,j])
        arr[i][j] = line[j]

#물 다음 고슴도치
move = [[0,1],[0,-1],[1,0],[-1,0]]
next_q = collections.deque()
def water(q) :
    global next_q
    while q :
        xy = q.popleft()
        for mv in move:
            x = xy[0] + mv[0]
            y = xy[1] + mv[1]
            if 0 <= x < r and 0 <= y < c and arr[x][y] == '.' :
                next_q.append([x,y])
                arr[x][y] = '*'

next_s = collections.deque()
def moving(s):
    global next_s
    while s:
        xy = s.popleft()
        for mv in move:
            x = xy[0] + mv[0]
            y = xy[1] + mv[1]
            if 0 <= x < r and 0 <= y < c and check_s[x][y] == 0 and (arr[x][y] == '.' or arr[x][y] == 'D'):
                check_s[x][y] = 1
                next_s.append([x,y])

res = 0
check_s = [[0 for _ in range(c)] for _ in range(r)]
while True:
    res += 1
    water(q)
    q = next_q
    next_q = collections.deque()
    moving(s)
    if d in next_s : 
        print(res)
        break
    if len(next_s) == 0 : 
        print("KAKTUS")
        break
    s = next_s
    next_s = collections.deque()
