import sys
input=sys.stdin.readline

n,m = map(int, input().strip().split())
tree = list(map(int, input().strip().split()))

left = 0
right= max(tree)

while left <= right :
  middle = (left + right) //2
  tree_sum = 0
  for i in tree:
    if i > middle :
      tree_sum += (i - middle)
  if tree_sum == m:
    right = middle
    break
  if tree_sum < m :
    right = middle - 1
  else :
    left = middle + 1

print(right)
