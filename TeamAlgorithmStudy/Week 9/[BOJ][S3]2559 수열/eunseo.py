import sys
input=sys.stdin.readline

n,k = map(int,input().split())
weather = list(map (int,input().split()))

start = 0
end = k - 1
res = 0
for i in range(end + 1):res += weather[i]
bf_temp = res
while end < n - 1:
  temp = bf_temp
  temp -= weather[start]
  start += 1
  end += 1
  temp += weather[end]
  res = max(res, temp)
  bf_temp = temp

print(res)
