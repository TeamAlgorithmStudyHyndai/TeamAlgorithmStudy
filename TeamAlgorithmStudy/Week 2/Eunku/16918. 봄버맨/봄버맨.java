import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, n;
    static Character[][] map;
    static Character[][] map_1;
    static Character[][] map_2;


    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new Character[r][c];
        map_1 = new Character[r][c];
        map_2 = new Character[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                map_1[i][j] = 'O';
                map_2[i][j] = 'O';

            }
        }   // 123212321

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    map_1[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= r || y < 0 || y >= c) continue;
                        if (map[x][y] != 'O') map_1[x][y] = '.';
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map_1[i][j] == 'O') {
                    map_2[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= r || y < 0 || y >= c) continue;
                        if (map_1[x][y] != 'O') map_2[x][y] = '.';
                    }
                }
            }
        }

        if (n==1){
            for (Character[] temp : map) {
                for (Character temp_1 : temp) {
                    System.out.print(temp_1);
                }
                System.out.println();
            }
            return;
        }
        if (n % 4 == 1) {
            for (Character[] temp : map_2) {
                for (Character temp_1 : temp) {
                    System.out.print(temp_1);
                }
                System.out.println();
            }
        } else if (n % 4 == 3) {
            for (Character[] temp : map_1) {
                for (Character temp_1 : temp) {
                    System.out.print(temp_1);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
        }
    }
}

