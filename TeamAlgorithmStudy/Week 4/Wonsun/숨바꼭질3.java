import java.util.*;
import java.io.*;
public class Main {    
	static int N;	// 수빈이의 위치
    static int K;	// 동생의 위치
    static int min = Integer.MAX_VALUE;	// 리턴할 최소 시간
    static int max = 100000; // 가능한 배열의 크기
    static boolean[] visited;    
    static class Subin {
        int x;		//위치
        int time;	//시간
        
        public Subin(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());	
        K = Integer.parseInt(st.nextToken());	
        
        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }
    
    public static void bfs() 
    {
        Queue<Subin> q = new LinkedList<>();
        q.offer(new Subin(N, 0));
        
        while(!q.isEmpty()) 
        {
            Subin Subin = q.poll();
            visited[Subin.x] = true;
            if(Subin.x == K) min = Math.min(min, Subin.time);
            // 1. 0초 후에 2*x 위치로 이동하는 경우
            if(Subin.x * 2 <= max && visited[Subin.x * 2] == false) q.offer(new Subin(Subin.x * 2, Subin.time));
            // 2. 1초 후에 x + 1 위치로 이동하는 경우
            if(Subin.x + 1 <= max && visited[Subin.x + 1] == false) q.offer(new Subin(Subin.x + 1, Subin.time + 1));
            // 3. 1초 후에 x - 1 위치로 이동하는 경우
            if(Subin.x - 1 >= 0 && visited[Subin.x - 1] == false) q.offer(new Subin(Subin.x - 1, Subin.time + 1));
        }
    }
    
    
}
