import sys
import copy
input = sys.stdin.readline

def dis(i,j,x,y):
    return abs(i-x) + abs(j - y)

n = int(input())
student = [list(map(int,input().split())) for _ in range(n*n)]

seat = [[0 for _ in range(n)]for _ in range(n)]

near = [[0,1],[1,0],[-1,0],[0,-1]]
def step1(likes):
    temp = {}
    max_key = 0
    for i in range(n):
        for j in range(n):
            if seat[i][j] != 0 : continue
            temp[(i,j)] = 0
            for nr in near:
                x = i + nr[0]
                y = j + nr[1]
                if 0 <= x < n and 0 <= y < n and seat[x][y] in likes :
                     temp[(i,j)] += 1
                     max_key = max(max_key, temp[(i,j)])
    res = [key for key, value in temp.items() if value == max_key]
    return res

def step2(seat_list):
    temp = {}
    max_key = 0
    for s in seat_list:
        temp[s] = 0
        for nr in near:
                x = s[0] + nr[0]
                y = s[1] + nr[1]
                if 0 <= x < n and 0 <= y < n and seat[x][y] == 0 :
                    temp[s] += 1
                    max_key = max(max_key, temp[s])
    res = [key for key, value in temp.items() if value == max_key]
    return res

for std in student:
    seat_list = step1(std[1:])
    if len(seat_list) == 1 :
        seat[seat_list[0][0]][seat_list[0][1]] = std[0]
        continue
    seat_list = step2(seat_list)
    if len(seat_list) == 1 :
        seat[seat_list[0][0]][seat_list[0][1]] = std[0]
        continue
    else :
        seat_list.sort()
        seat[seat_list[0][0]][seat_list[0][1]] = std[0]

res = 0
score = {0:0, 1:1, 2:10, 3:100, 4:1000}
for i in range(n):
    for j in range(n):
        likes = []
        for std in student:
           if std[0] == seat[i][j] :
               likes = std[1:]
               break
        num = 0
        for nr in near:
            x = i + nr[0]
            y = j + nr[1]
            if 0 <= x < n and 0 <= y < n and seat[x][y] in likes : num += 1
        res += score[num]

print(res)
