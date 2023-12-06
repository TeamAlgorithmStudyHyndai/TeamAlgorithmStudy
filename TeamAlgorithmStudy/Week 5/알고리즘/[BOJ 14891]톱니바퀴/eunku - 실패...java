package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GearRotation {
    static ArrayList<Integer>[] gear = new ArrayList[4];
    static int[][] dir;
    static boolean[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String st = br.readLine();
            gear[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                gear[i].add(Character.getNumericValue(st.charAt(i)));
            }
        }

        int n = Integer.parseInt(br.readLine());
        dir = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            dir[i][0] = Integer.parseInt(st.nextToken());
            dir[i][1] = Integer.parseInt(st.nextToken());
        }

        map = new boolean[3];

        for (int i = 0; i < n; i++) {
            int a = dir[i][0];
            int b = dir[i][1];
            check();
            rotate(a - 1, b);

            if (a == 4) {
                for (int j = 3; j > 0; j--) {
                    if (map[j - 1]) {
                        b *= -1;
                        rotate(j - 1, b);
                    } else break;
                }
            }

            if (a == 1) {
                for (int j = 0; j < 3; j++) {
                    if (map[j]) {
                        b *= -1;
                        rotate(j + 1, b);
                    } else break;
                }
            }

            if (a == 2) {
                if (map[0]) {
                    rotate(0, b * -1);
                }
                if (map[1]) {
                    rotate(a, b * -1);
                    if (map[2]) {
                        rotate(a + 1, b);
                    }
                }
            }

            if (a == 3) {
                if (map[2]) {
                    rotate(3, b * -1);
                }
                if (map[1]) {
                    rotate(1, b * -1);
                    if (map[0]) {
                        rotate(0, b);
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i].get(0) == 1) {
                sum += Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }

    static void check() {
        for (int i = 0; i < 3; i++) {
            if (gear[i].get(2).equals(gear[i + 1].get(6))) {
                map[i] = true;
            } else map[i] = false;
        }
    }

    static void rotate(int n, int m) {
        if (m == 1) {
            int temp = gear[n].remove(7);
            gear[n].add(0, temp);
        }
        if (m == -1) {
            int temp = gear[n].remove(0);
            gear[n].add(temp);
        }
    }
}