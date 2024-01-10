import sys
input = sys.stdin.readline

test = int(input())

def cal(idx, num, res, cnt):
    if idx == len(num) :
        if cnt == 0 : print(res)
        return 
    bf_num =0
    mul = 10
    bf_cal = ''
    for i in range(len(res) - 1, -1, -1):
        if res[i] == ' ' : continue
        if res[i] == '+' or res[i] == '-': 
            bf_cal =res[i]
            break
        bf_num += int(res[i]) * mul
        mul *= 10
    new_cnt = bf_num + num[idx]
    if bf_cal == '' :  #0번 인덱스
        cal(idx + 1, num, res + " " + str(num[idx]), new_cnt)
    elif bf_cal == '+' :
        cal(idx + 1, num, res + " " + str(num[idx]), cnt - int(res[-1]) + new_cnt)
    elif bf_cal == '-' :
        cal(idx + 1, num, res + " " + str(num[idx]), cnt + int(res[-1]) - new_cnt)

    cal(idx + 1, num, res + "+" + str(num[idx]), cnt + num[idx])
    cal(idx + 1, num, res + "-" + str(num[idx]), cnt - num[idx])
    
for t in range(test):
    n = int(input())
    num = [int(i) for i in range(1,n + 1)]
    cal(1, num, "1", 1)
    print()
