import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(String[] board) {
        int row = board[0].length();
        int col = board.length;
        char[][] map = new char[col][row];
        int[][] dis = new int[col][row];
        boolean[][] visited = new boolean[col][row];
        int temp = 0;
        for(String rows : board){
            char[] rowChar = rows.toCharArray();
            map[temp++] = rowChar;
        }
        int rX = 0;
        int rY = 0;
        
        int gX =0;
        int gY = 0;
        for (int i =0; i<col; i++){
            for (int j=0; j<row; j++){
                if(map[i][j]== 'R'){
                    rX = i;
                    rY = j;
                }
                if(map[i][j] =='G'){
                    gX = i;
                    gY = j;
                }
            }
        }
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{rX,rY});
        visited[rX][rY] = true;
        while(!que.isEmpty()){
            int[] robot = que.poll();
            int x = robot[0];
            int y = robot[1];
            for(int i =0; i<4; i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                
                if(nextX <0 || nextX>=col || nextY < 0 || nextY >=row
                  || map[nextX][nextY] =='D') continue;
                
                while(nextX >=0 && nextX < col && nextY>=0 && nextY <row){
                    nextX += dx[i];
                    nextY += dy[i];
                    if(nextX <0 || nextX>=col || nextY < 0 || nextY >=row
                       || map[nextX][nextY] =='D') {
                        nextX -= dx[i];
                        nextY -= dy[i];
                        if(!visited[nextX][nextY]){
                            dis[nextX][nextY] = dis[x][y] + 1;
                            visited[nextX][nextY] = true;
                            que.add(new int[]{nextX, nextY});
                        }
                        break;
                        
                    }
                    
                }
                
            }
        }
        if (dis[gX][gY] == 0) {
            return -1;
        } else return dis[gX][gY];

    }
}