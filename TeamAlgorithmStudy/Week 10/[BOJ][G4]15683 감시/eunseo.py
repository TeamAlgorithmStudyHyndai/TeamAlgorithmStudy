import sys
import copy
import collections
input = sys.stdin.readline

n,m = map(int, input().split())
office = [list(map(int,input().split())) for _ in range(n)]

cctv = []
for i in range(n):
    for j in range(m):
        if 0 < office[i][j] < 6 : cctv.append([i,j])

def change_map_1(maps_origin, x, y, degree):
    maps = copy.deepcopy(maps_origin)
    if degree == 0:
        for i in range(y + 1,m): 
            if maps[x][i] == 6 : break
            if maps[x][i] == 0 : maps[x][i] = -1
    elif degree == 90:
        for i in range(x + 1,n): 
            if maps[i][y] == 6 : break
            if maps[i][y] == 0 :maps[i][y] = -1  
    elif degree == 180 :
        for i in range(y - 1, -1, -1):
            if maps[x][i] == 6 : break
            if maps[x][i] == 0 :maps[x][i] = -1
    else :
        for i in range(x - 1, -1, -1):
            if maps[i][y] == 6 : break
            if maps[i][y] == 0 : maps[i][y] = -1
    return maps
    # for i in range(n):
    #     print(maps[i])
    # print()

def change_map_2(maps_origin,x,y,degree):
    maps = copy.deepcopy(maps_origin)
    if degree == 0:
        maps = change_map_1(maps,x,y,270)
        maps = change_map_1(maps,x,y,90)
    else :
        maps = change_map_1(maps,x,y,0)
        maps = change_map_1(maps,x,y,180)
    return maps

def change_map_3(maps_origin,x,y,degree):
    maps = copy.deepcopy(maps_origin)
    if degree == 0 : 
        maps = change_map_1(maps,x,y,270)
        maps = change_map_1(maps,x,y,0)
    elif degree == 90 :
        maps = change_map_1(maps,x,y,90)
        maps = change_map_1(maps,x,y,0)
    elif degree == 180 :
        maps = change_map_1(maps,x,y,90)
        maps = change_map_1(maps,x,y,180)
    else :
        maps = change_map_1(maps,x,y,270)
        maps = change_map_1(maps,x,y,180)
    return maps

def change_map_4(maps_origin,x,y,degree):
    maps = copy.deepcopy(maps_origin)
    if degree == 0 : 
        maps = change_map_2(maps,x,y,90)
        maps = change_map_1(maps,x,y,270)
    elif degree == 90 :
        maps = change_map_2(maps,x,y,0)
        maps = change_map_1(maps,x,y,0)
    elif degree == 180 :
        maps = change_map_2(maps,x,y,90)
        maps = change_map_1(maps,x,y,90)
    else :
        maps = change_map_2(maps,x,y,0)
        maps = change_map_1(maps,x,y,180)
    return maps

def change_map_5(maps_origin,x,y):
    maps = copy.deepcopy(maps_origin)
    maps = change_map_2(maps,x,y,0)
    maps = change_map_2(maps,x,y,90)
    return maps

res = sys.maxsize
def check_office(maps):
    res = 0
    move = [[0,1],[0,-1],[1,0],[-1,0]]
    check = [[0 for _ in range(m)]for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if check[i][j] == 0 and maps[i][j] == 0 :
                res += 1
                check[i][j] = 1
                q = collections.deque()
                q.append([i,j])
                while q :
                    xy = q.popleft()
                    for mv in move:
                        x = xy[0] + mv[0]
                        y = xy[1] + mv[1]
                        if 0 <= x < n and 0 <= y < m and check[x][y] == 0 and maps[x][y] == 0:
                            check[x][y] = 1
                            res += 1
                            q.append([x,y])
    return res

checking_set = set()
def change_map(idx,maps_origin,status):
    global checking_set
    global res
    if res == 0 : return
    if idx == len(cctv) : return res
    x = cctv[idx][0]
    y = cctv[idx][1]
    tv = office[x][y]
    if tv == 1 :
        degree = [0,90,180,270]
        for i in range(4):
            maps = copy.deepcopy(maps_origin)
            new_status = status + str(tv) + str(degree[i])
            if new_status in checking_set : continue
            checking_set.add(new_status)
            new_map = change_map_1(maps, x,y, degree[i])
            res = min(res, check_office(new_map))
            change_map(idx + 1, new_map,new_status)
    elif tv == 2 :
        degree = [0,90]
        for i in range(2):
            maps = copy.deepcopy(maps_origin)
            new_status = status + str(tv) + str(degree[i])
            if new_status in checking_set : continue
            checking_set.add(new_status)
            new_map = change_map_2(maps, x,y, degree[i])
            res = min(res, check_office(new_map))
            #print(new_map,degree[i])

            change_map(idx + 1, new_map,new_status)
    elif tv == 3 :
        degree = [0,90,180,270]
        for i in range(4):
            maps = copy.deepcopy(maps_origin)
            new_status = status + str(tv) + str(degree[i])
            if new_status in checking_set : continue
            checking_set.add(new_status)
            new_map = change_map_3(maps, x,y, degree[i])
            res = min(res, check_office(new_map))
            change_map(idx + 1, new_map,new_status)
    elif tv == 4 :
        degree = [0,90,180,270]
        for i in range(4):
            maps = copy.deepcopy(maps_origin)
            new_status = status + str(tv) + str(degree[i])
            if new_status in checking_set : continue
            checking_set.add(new_status)
            new_map = change_map_4(maps, x,y, degree[i])
            res = min(res, check_office(new_map))
            change_map(idx + 1, new_map,new_status)
    else :
        maps = copy.deepcopy(maps_origin)
        new_status = status + str(tv)
        if new_status not in checking_set : 
            checking_set.add(new_status)
            new_map = change_map_5(maps, x,y)
            res = min(res, check_office(new_map))
            change_map(idx + 1, new_map,new_status)
if len(cctv) == 0 : 
    ans = 0
    for i in range(n):
        for j in range(m):
            if office[i][j] == 0 : ans+= 1
    print(ans)
else:
    change_map(0,office, "")
    print(res)
