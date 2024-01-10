import sys
input = sys.stdin.readline

n, k = map(int, input().split())
belt = list(map(int, input().split()))

robot = [0 for _ in range(2*n)]
step = 1
def step_1() :
    temp_b = belt[2 * n - 1]
    temp_r = robot[2 * n - 1]
    for i in range(2 * n - 2, -1, -1):
        belt[i + 1] = belt[i]
        robot[i + 1] = robot[i]
    belt[0] = temp_b
    robot[0] = temp_r
    robot[n - 1] = 0
def step_2() :
    temp_r = robot[2 * n - 1]
    for i in range(2 * n - 2, -1, -1):
        if robot[i] == 0 : continue
        if belt[i + 1] > 0 and robot[i + 1] == 0 :
            robot[i + 1] = robot[i]
            robot[i] = 0
            belt[i + 1] -= 1
    robot[0] = temp_r
    robot[n - 1] = 0
def step_3():
    if belt[0] > 0 and robot[0] == 0:
        robot[0] = 1
        belt[0] -= 1
res = 1

while True:
    step_1()
    step_2()
    step_3()
    if belt.count(0) >= k :
        print(res)
        break
    res += 1
