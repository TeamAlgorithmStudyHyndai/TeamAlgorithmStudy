import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    n = int(input())
    people = [list(map(int, input().split())) for _ in range(n)]

    sorted_paper =sorted(people)

    res = 0
    min = sorted_paper[0][1] 
    for i in range(n):
        if min >= sorted_paper[i][1]:
            res += 1
            min = sorted_paper[i][1]
    print(res)
        
    
