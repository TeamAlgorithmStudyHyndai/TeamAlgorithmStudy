import sys
import collections
input = sys.stdin.readline

while True:
    l,r,c = map(int,input().split())
    if l == 0 and r == 0 and c == 0: break
    building = [[list(input().strip()) for _ in range(r)]]
    for i in range(l - 1):
        input()
        temp = [list(input().strip()) for _ in range(r)]
        building.append(temp)

    start = []
    end = []
    def find_start_end():
        global start
        global end
        for i in range(l):
            for j in range(r):   
                for k in range(c):
                    if len(start) != 0 and len(end) != 0 : return
                    if building[i][j][k] == 'S':
                        temp = [i,j,k]
                        start.extend(temp)
                    if building[i][j][k] == 'E': 
                        temp = [i,j,k]
                        end.extend(temp)
    find_start_end()
    
    q = collections.deque()
    q.append([start, 0])
    move = [[0,1,0],[0,-1,0], [0,0,1], [0,0,-1], [1,0,0],[-1,0,0]]
    res = sys.maxsize
    check = [[[0 for _ in range(c)] for _ in range(r)] for _ in range(l)]
    check[start[0]][start[1]][start[2]] = 1
    while q:
        xyz = q.popleft()
        x = xyz[0][0]
        y = xyz[0][1]
        z = xyz[0][2]
        sec = xyz[1]
        if building[x][y][z] == 'E' : res = min(res,sec)
        for mv in move:
            xx = x + mv[0]
            yy = y + mv[1]
            zz = z + mv[2]
            if (0 <= xx < l and 0 <= yy < r and 0 <= zz < c) == False : continue
            if check[xx][yy][zz] == 0 and building[xx][yy][zz] != '#':
                check[xx][yy][zz] = 1
                q.append([[xx,yy,zz], sec + 1])

    if res == sys.maxsize : print("Trapped!")
    else : print("Escaped in",res, "minute(s).")
    input()
