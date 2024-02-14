import java.util.*;

class Solution {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int len; // board 한 변 길이
    
    public int solution(String[] board) {
        len = board.length;
        int ry = -1,rx = -1; // 로봇 좌표
        int gy = -1, gx = -1; // 목표위치 좌표
        /* 로봇, 목표지점 좌표 찾기*/
        for (int i = 0; i < len; i++)
        {
            String line = board[i];
            for (int j = 0; j < board[i].length(); j++)
            {
                if (line.charAt(j) == 'R')
                {
                    ry = i;
                    rx = j;
                }
                if (line.charAt(j) == 'G')
                {
                    gy = i;
                    gx = j;
                }
            }
        } // end for
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[len][board[0].length()];
        int count = 0;
        que.add(new int[] {ry,rx, count});
        while(!que.isEmpty())
        {
            int[] cur = que.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curCount = cur[2];
            visited[curY][curX] = true;
            
            if(board[curY].charAt(curX) == 'G')
            {
                return curCount;
            }
            for (int i = 0; i < 4; i++)
            {
                int[] next = slide(curY, curX, i, board);
                
                if (visited[next[0]][next[1]] == true)
                    continue;
                que.add(new int[] {next[0], next[1], cur[2] + 1});
            }
        }
        return -1;
    }
    
    static int[] slide(int y, int x, int d, String[] board) {
        int[] direction = dir[d];
        int ny = y;
        int nx = x;
        // 장애물이나 벽을 만날 때 까지 이동
        while (true)
        {
            if (ny + direction[0] < 0 || nx + direction[1] < 0 
                || ny + direction[0] >= board.length 
                || nx  + direction[1] >= board[0].length())
                break;
            if (board[ny + direction[0]].charAt(nx + direction[1]) == 'D')
                break;
            ny += direction[0];
            nx += direction[1];
         
        }
        return new int[] {ny, nx};
    }
    
}
