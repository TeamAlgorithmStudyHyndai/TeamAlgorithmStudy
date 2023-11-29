import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr= new int[100001];
        Queue<Integer> que = new LinkedList<>();

        que.offer(n);
        arr[n] = 1;
        while(!que.isEmpty()){
            int temp = que.poll();
            int temp_tel = temp;
            while(temp_tel * 2<100001){
                if(arr[temp_tel *2] !=0) break;
                temp_tel *=2;
                if(arr[temp_tel] ==0){
                    arr[temp_tel] = arr[temp];
                    que.offer(temp_tel);
                }
            }
            if(temp-1>=0 &&arr[temp-1] ==0){
                arr[temp-1] = arr[temp]+1;
                que.offer(temp-1);
            }
            if(temp+1<100001 && arr[temp+1] ==0){
                arr[temp+1] = arr[temp]+1;
                que.offer(temp+1);
            }
            if(arr[m] !=0) break;
        }
        System.out.println(arr[m]-1);
    }
}
