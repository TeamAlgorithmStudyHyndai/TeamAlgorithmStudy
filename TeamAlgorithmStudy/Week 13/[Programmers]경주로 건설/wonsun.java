import java.util.*;

class Solution {
    static int[][][] cost;
    static int N;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우

    static int solution(int[][] board) {
        N = board.length;
        cost = new int[4][N][N]; // 방향, 행, 열
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++) 
            {
                for (int k = 0; k < 4; k++)
                {
                    cost[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        Queue<int[]> que = new LinkedList<>();
        if(board[1][0] == 0)
        {
            cost[1][1][0] = 100; // (0, 0) 에서 아래 방향
            que.add(new int[]{1,0,1});
        }
        if(board[0][1] == 0)
        {
            cost[3][0][1] = 100; // (0,0) 에서 오른족 방향
            que.add(new int[]{0,1,3});
        }

        while(!que.isEmpty())
        {
            int[] cur = que.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curDir = cur[2];

            for(int i = 0; i < 4; i++)
            {
                int ny = curY + dir[i][0];
                int nx = curX + dir[i][1];
                if(!rangeCheck(ny, nx) || board[ny][nx] == 1)
                    continue;
                if(curDir != i) // 방향이 달라질 경우
                {    
                    if(curDir + i == 1 || curDir + i > 4)  
                        continue; 
                    if(cost[i][ny][nx] < cost[curDir][curY][curX] + 600) 
                        continue;
                    que.add(new int[]{ny,nx,i});
                    cost[i][ny][nx] = cost[curDir][curY][curX] + 600;
                }
                else // 직선으로 갈 경우
                { 
                    if(cost[i][ny][nx] < cost[curDir][curY][curX] + 100)
                        continue;
                    que.add(new int[]{ny, nx, i});
                    cost[i][ny][nx] = cost[curDir][curY][curX] + 100;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++)
            result = (result > cost[i][N-1][N-1]) ? cost[i][N-1][N-1] : result;
        return result;
    }

    static boolean rangeCheck(int y, int x){
        if(y < 0 || y >= N || x < 0 || x >= N)
            return false;
        return true;
    }
}
