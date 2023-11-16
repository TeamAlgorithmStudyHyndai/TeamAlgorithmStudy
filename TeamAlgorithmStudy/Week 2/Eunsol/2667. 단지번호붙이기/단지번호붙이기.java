
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static boolean[][] visited;
	static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Main ma = new Main();
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][num];
        visited = new boolean [num][num];
        List<Integer> list  = new ArrayList<Integer>();
        
        //Line을 통해 입력받아 charAt으로 넣기
        for (int i = 0; i < num; i++) {
            String row = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        br.close();
        
        for(int i = 0 ; i<arr.length; i++) {
        	 for(int j = 0 ; j<arr.length; j++) {
        		if(!visited[i][j]&& arr[i][j]==1) {
        			count= 0;
        			ma.DFS(arr, i, j);
        			list.add(count);
        		}
        	 }
        }
        
      Collections.sort(list);
      
      System.out.println(list.size());
      
      for(int i = 0 ; i < list.size() ;i++) {
    	  System.out.println(list.get(i));
      }
    }
    public void DFS(int[][] arr, int i, int j) {
    	visited[i][j] = true;
    	count++;
    	if(i-1 >=0 && !visited[i-1][j] && arr[i-1][j]==1) {
    		DFS(arr,i-1,j);
    	}
    	if(i+1 < arr.length && !visited[i+1][j]&& arr[i+1][j]==1) {
    		DFS(arr,i+1,j);
    	}
    	if(j-1 >=0 && !visited[i][j-1] && arr[i][j-1]==1) {
    		DFS(arr,i,j-1);
    	}
    	if(j+1 < arr.length && !visited[i][j+1]&& arr[i][j+1]==1) {
    		DFS(arr,i,j+1);
    	}
    }
}
