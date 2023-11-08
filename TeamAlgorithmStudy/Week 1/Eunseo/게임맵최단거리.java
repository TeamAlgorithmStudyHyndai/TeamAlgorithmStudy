import java.util.*;
class Tuple{
    int x;
    int y;
    int z;
    public Tuple(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class Solution {
    public int solution(int[][] maps) {
        Queue<Tuple> q = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = maps.length;
        int m = maps[0].length;
        int answer = n * m + 1;
        int[][] check = new int[n + 1][m + 1];
        q.offer(new Tuple(0,0,1));
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
             //System.out.println(t.x + "/" + t.y + "/" + t.z);
            if(t.x == n - 1 && t.y == m - 1){
                answer = Math.min(answer, t.z);
            }
            for(int i =0; i< 4;i++){
                int xx = t.x + dx[i];
                int yy = t.y + dy[i];
                if(isAvail(xx, yy, n, m) && maps[xx][yy] == 1 && check[xx][yy] == 0){
                    q.offer(new Tuple(xx,yy, t.z + 1));
                    check[xx][yy] = 1;
                }
            }
           
        }
        if(answer == n * m + 1) return -1;
        return answer;
    }
    public boolean isAvail(int x, int y, int n, int m){
        if(x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }
}
