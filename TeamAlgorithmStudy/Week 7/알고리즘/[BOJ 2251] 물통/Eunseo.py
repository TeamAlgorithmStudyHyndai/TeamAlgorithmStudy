import sys
import collections
input=sys.stdin.readline

a,b,c = map(int, input().strip().split())

#a to b / a to c
#b to a / b to c
#c to a / c to b

def bfs():
  res = set([])
  res.add(c)
  check = [[[0 for _ in range(201)] for _ in range(201)] for _ in range(201)]
  q = collections.deque()
  q.append([0,0,c])
  while q:
    abc = q.popleft()
    A = abc[0]
    B = abc[1]
    C = abc[2]
    if check[A][B][C] == 1 : continue
    check[A][B][C] = 1
    if A == 0:
      res.add(C)
    if A + B > b: q.append([A + B - b, b, C])
    else : q.append([0,A+B,C])

    if A + C > c: q.append([A + C - c, B, c])
    else : q.append([0,B,A + C])

    if B + C > c: q.append([A, B + C -c, c])
    else : q.append([A,0, B + C])
    
    if B + A > a: q.append([a, B + A -a, C])
    else : q.append([A + B, 0, C])
    
    if C + A > a: q.append([a, B, C + A - a])
    else : q.append([A + C,B, 0])
    
    if C + B > b: q.append([A, b, C + B - b])
    else : q.append([A ,B + C, 0])

  sorted_list = sorted(res)
  for i in sorted_list:
    print(i, end=" ")  

bfs()  
