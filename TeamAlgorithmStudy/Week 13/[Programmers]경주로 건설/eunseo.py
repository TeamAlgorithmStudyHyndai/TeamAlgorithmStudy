from collections import deque

def solution(board):
    def bfs(start):
        move = [[-1, 0],[0, 1],[1, 0],[0, -1]] # 북,동,남,서
        n = len(board)
        check = [[2_100_000_000] * n for _ in range(n)]
        check[0][0] = 0

        q = deque([start]) # x, y, cost, dir
        while q:
            x, y, cost, d = q.popleft()
            for i in range(4):
                xx = x + move[i][0]
                yy = y + move[i][1]

                if 0 <= xx < n and 0 <= yy < n and board[xx][yy] == 0:
                    if i == d : temp = cost + 100
                    else : temp =  cost + 600
                    if temp < check[xx][yy]:
                        check[xx][yy] = temp
                        q.append([xx, yy, temp, i])
                        
        return check[n-1][n-1]
    
    return min([bfs((0, 0, 0, 1)), bfs((0, 0, 0, 2))])
