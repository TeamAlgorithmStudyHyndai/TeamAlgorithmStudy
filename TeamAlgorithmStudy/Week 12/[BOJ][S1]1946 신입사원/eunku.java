import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            ArrayList<int[]> arr = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                arr.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            arr.sort((Comparator.comparingInt(o -> o[0])));
            int count = 1;
            int test2 =  arr.get(0)[1];
            for (int j = 1; j < m; j++) {
                if(test2 >arr.get(j)[1]){
                    count++;
                    test2 = arr.get(j)[1];
                }
            }
            System.out.println(count);
        }
    }
}

