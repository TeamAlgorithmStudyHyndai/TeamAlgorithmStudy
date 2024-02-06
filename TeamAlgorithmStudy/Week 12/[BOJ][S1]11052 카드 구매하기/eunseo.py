import sys
input = sys.stdin.readline

n = int(input())
money = list(map(int,input().split()))

dp = [0 for _ in range(n)]
dp[0] = money[0] #1장 샀을 때 최대값
for i in range(1, n):
    for j in range(i): 
        dp[i] = max(dp[i], money[i], dp[j] + dp[i - j - 1])

print(dp[n-1])
