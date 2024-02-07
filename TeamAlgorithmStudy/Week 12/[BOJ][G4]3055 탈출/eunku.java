import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] distance;
    static Loc beber, go;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Loc {
        int x, y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        distance = new int[R][C];
        Queue<Loc> water = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'D') {
                    beber = new Loc(i, j);
                    continue;
                }
                if (map[i][j] == 'S') {
                    go = new Loc(i, j);
                    continue;
                }
                if (map[i][j] == '*') {
                    water.add(new Loc(i, j));
                }
            }
        }
        Queue<Loc> que = new LinkedList<>();
        que.add(go);
        while (!que.isEmpty()) {
            int num  = water.size();
            if(num !=0){
                for (int j = 0; j < num; j++) {
                    Loc waterLoc = water.poll();
                    int waterX = waterLoc.x;
                    int waterY = waterLoc.y;

                    for (int i = 0; i < 4; i++) {
                        int moveWaterX = waterX + dx[i];
                        int moveWaterY = waterY + dy[i];
                        if (moveWaterX < 0 || moveWaterX >= R || moveWaterY < 0 || moveWaterY >= C) continue;
                        if (map[moveWaterX][moveWaterY] == '.' || map[moveWaterX][moveWaterY] == 'S') {
                            map[moveWaterX][moveWaterY] = '*';
                            water.add(new Loc(moveWaterX, moveWaterY));
                        }
                    }
                }
            }


            for (int j = 0; j < que.size(); j++) {
                Loc temp = que.poll();
                int x = temp.x;
                int y = temp.y;
                for (int i = 0; i < 4; i++) {
                    int moveGoX = x + dx[i];
                    int moveGoY = y + dy[i];
                    if (moveGoX < 0 || moveGoX >= R || moveGoY < 0 || moveGoY >= C) continue;

                    if (map[moveGoX][moveGoY] == 'D' && distance[moveGoX][moveGoY] ==0) {
                        distance[moveGoX][moveGoY] = distance[x][y] + 1;
                        break;
                    }

                    if (map[moveGoX][moveGoY] == '.' && distance[moveGoX][moveGoY] == 0) {
                        distance[moveGoX][moveGoY] = distance[x][y] + 1;
                        que.add(new Loc(moveGoX, moveGoY));
                    }

                }
            }
        }
        if(distance[beber.x][beber.y] ==0){
            System.out.println("KAKTUS");
        } else {
            System.out.println(distance[beber.x][beber.y]);
        }

    }
}
