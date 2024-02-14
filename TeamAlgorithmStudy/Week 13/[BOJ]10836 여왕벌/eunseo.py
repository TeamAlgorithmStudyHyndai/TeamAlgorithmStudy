import sys
input = sys.stdin.readline

m,n = map(int,input().split())
bee = [1 for _ in range(2 * m + 1)]

for _ in range(n):
    a,b,c = map(int, input().split())
    for i in range(a, a + b):bee[i] += 1
    for i in range(a + b, a + b + c):bee[i] += 2

for i in range(m):
    for j in range(m):
        if j > 0:
            print(bee[m + j - 1], end= " ")
        else : print(bee[m - i - 1], end = " ")
    print()
