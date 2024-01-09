def solution(m, n, puddles):
  div = 1_000_000_007
  dp=[[0 for _ in range(n)] for _ in range(m)] #해당 좌표에 최단거리로 도달하는 방법의 가지수
  dp[0][0] = 1
    
  for water in puddles:
    if water != [] : dp[water[0]-1][water[1]-1] = -1

  for i in range(1, n):
    if dp[0][i] == -1 : continue
    if dp[0][i-1] == -1 : break
    else : dp[0][i] = 1
  
  for i in range(1,m):
    if dp[i][0] == -1 : continue
    if dp[i-1][0] == -1 : break
    else : dp[i][0] = 1

  for i in range(1, m):
    for j in range(1, n):
      if dp[i][j] == -1 : continue
      temp = 0
      if dp[i-1][j] != -1 : temp += dp[i-1][j]
      if dp[i][j-1] != -1 : temp += dp[i][j-1]
      dp[i][j] = temp % div

  answer = dp[m-1][n-1] % div
  return answer
