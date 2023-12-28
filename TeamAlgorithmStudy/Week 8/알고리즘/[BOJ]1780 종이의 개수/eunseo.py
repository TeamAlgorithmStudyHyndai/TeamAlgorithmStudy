import sys
input=sys.stdin.readline

n = int(input().strip())
paper=[]
for i in range(n):
    paper.append(list(map(int,input().strip().split())))

count = {'-1': 0, '0': 0, '1': 0}

def check(x, y, size):
  current = paper[x][y]
  for i in range(x, x + size):
      for j in range(y, y + size):
          if paper[i][j] != current:
              for m in range(3):
                  for n in range(3):
                    check(x + m * (size // 3), y + n * (size // 3), size // 3)
              return
  count[str(current)] += 1

check(0, 0, n)
print(count['-1'])
print(count['0'])
print(count['1'])
