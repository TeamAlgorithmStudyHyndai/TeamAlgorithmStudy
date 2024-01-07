import sys
input=sys.stdin.readline

n = int(input())
room = []
for i in range(n):
  room.append(list(map(int,input().split())))

dp=[[0 for _ in range(n)] for _ in range(n)]
status = 0 # 0 = 가로, 1 = 세로, 2 = 대각

dp[0][1] = 1

def check(status, i,j):
  if j < n - 1 and status != 1 and room[i][j+1] == 0 :
    dp[i][j+1] += 1
    check(0, i, j+1)
  if i < n - 1 and status != 0 and room[i+1][j] == 0 :
    dp[i+1][j] += 1
    check(1, i+1, j)  
  if i < n - 1 and j < n - 1 and room[i][j+1] == room[i+1][j] == room[i+1][j+1] == 0:
    dp[i+1][j+1] += 1
    check(2, i+1, j+1)

check(0,0,1)
print(dp[n-1][n-1])
