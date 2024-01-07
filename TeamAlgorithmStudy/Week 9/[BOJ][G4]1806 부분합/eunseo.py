import sys
input=sys.stdin.readline

n,s = map(int,input().split())
num = list(map (int,input().split()))

start = 0
end = 0
my_sum = num[0]
res = 100_000_003
while start <= end and end < n-1:
  while my_sum < s and end < n -1:
    end += 1
    my_sum += num[end]
  while my_sum >= s and start <= end :
    if my_sum >= s : res = min(res, end - start + 1)   
    my_sum -= num[start]
    start += 1
  
if res == 100_000_003 : res = 0
print(res)
