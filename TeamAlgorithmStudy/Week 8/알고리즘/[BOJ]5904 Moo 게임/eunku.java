import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check(N);
    }
    static void check(int n){
        int size = 3;
        int index = 0;
        if(n == 1){
            System.out.println("m");
        } else if (n  <=3) {
            System.out.println("o");
        }else {
            while(size < n){
                size = size * 2 + index + 4;
                index++;
            }
            int frontHalf = (size - index -3)/2;

            if(size - frontHalf < n){
                check(n -size + frontHalf);
            }else if(n == frontHalf +1) {
                System.out.println("m");
            }else System.out.println("o");

        }
    }
}
