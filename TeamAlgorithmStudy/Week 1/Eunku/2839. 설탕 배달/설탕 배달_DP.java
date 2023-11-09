import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static Queue<Integer> Q = new LinkedList<>();
    static int[] arr = new int[5010];
    static int[] sugar = {3,5};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print(def(N));

    }
    public static int def(int N){
        int start = 0;
        int count = 1;
        Q.offer(start);
        while(!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i <len; i++){
                int temp = Q.poll();
                for(int a : sugar){
                    if(temp + a == N){
                        return count;
                    }
                    if(arr[temp + a] == 0 && temp+a < 5005){
                        arr[temp + a] = count;
                        Q.offer(temp + a);
                    }
                }

            }
            count++;
        }
        return -1;
    }
}
