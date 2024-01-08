import sys
input=sys.stdin.readline

n,k = map(int,input().split())
num = list(map (int,input().split()))

start = 0
end = 0
check = {}
res = 0
check[num[0]] = 1
while start <= end and end < n - 1:
  end += 1
  the_num = num[end]
  if the_num not in check:
    check[the_num] = 1
  else: check[the_num] += 1
  while check[the_num] > k:
    check[num[start]] -= 1
    start += 1 
  res = max(res, end - start + 1)
    
print(res)
