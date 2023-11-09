import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int count = 0;
        while(sugar >0){
        if(sugar % 5 == 0){
            count += sugar / 5;
            System.out.print(count);
            return;
     
        }
        if(sugar < 3){
            System.out.print(-1);
            return;
        }
        sugar -= 3;
        count++;    
    }
    System.out.print(count);
    }
}