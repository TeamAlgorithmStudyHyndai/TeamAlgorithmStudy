
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        int[] arr= new int[n];
        for(int i =0; i< n; i++)
        	arr[i] = Integer.parseInt(s[i]);
        list.add(n); //마지막 사람은 어디에 서든 항상 0임
        for(int i = n - 2; i>=0; i--) {
        	if(arr[i] >= list.size()) list.add(list.size(), i + 1);
        	else list.add(arr[i], i + 1);
        } 
        for(int i =0; i< list.size(); i++)
        	System.out.print(list.get(i) + " ");
	}
}