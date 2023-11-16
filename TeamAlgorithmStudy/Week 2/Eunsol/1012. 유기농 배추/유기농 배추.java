
import java.util.Scanner;

public class Main {

	static boolean [][] visit ;
	static int count = 0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		int T = sc.nextInt();
		
		for(int i = 0 ; i <T ;i++) {
			count=0;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			int [][] arr = new int[M][N];
			visit = new boolean[M][N];
			for(int j = 0 ; j<K ;j++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				arr[num1][num2] = 1;
			}
			
			for(int j = 0 ; j <M ; j++) {
				for(int k = 0 ; k <N; k++) {
					if(!visit[j][k] && arr[j][k]== 1) {
						ma.DFS(arr, j ,k);
						count++;
					}
				}
			} 
			System.out.println(count);
		}
	}
	public void DFS(int[][] arr, int j, int k) {
	    visit[j][k] = true;
	    if (j - 1 >= 0 && !visit[j - 1][k] && arr[j - 1][k] == 1)
	        DFS(arr, j - 1, k);
	    if (j + 1 < arr.length && !visit[j + 1][k] && arr[j + 1][k] == 1)
	        DFS(arr, j + 1, k);
	    if (k - 1 >= 0 && !visit[j][k - 1] && arr[j][k - 1] == 1)
	        DFS(arr, j, k - 1);
	    if (k + 1 < arr[j].length && !visit[j][k + 1] && arr[j][k + 1] == 1)
	        DFS(arr, j, k + 1);
	}
}
