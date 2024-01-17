package week10;

import java.io.*;
import java.util.*;
public class 컨베이어벨트위의로봇 {
	static int N;
	static int K;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < belt.length; i++) 
        {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(moveRobot());
    }

    private static int moveRobot() 
    {
        int cnt = 0;

        while (checkDurability())
        {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            int tmp = belt[belt.length - 1];
            for (int i = belt.length - 1; i > 0; i--) 
            {
                belt[i] = belt[i - 1];
            }
            // [0] -> [2N - 1]
            belt[0] = tmp;

            for (int i = robot.length - 1; i > 0; i--) 
            {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한칸 이동 가능
            for (int i = robot.length - 1; i > 0; i--) 
            {
                if (robot[i - 1] && !robot[i] && belt[i] >= 1) 
                {
                    belt[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇 올림
            if (belt[0] > 0) 
            {
                robot[0] = true;
                belt[0]--;
            }

            cnt++;
        }

        return cnt;
    }

    private static boolean checkDurability() 
    {
        // 4. 내구도가 0 칸의 개수가 k개 이상 -> 종료
        int cnt = 0;
        for (int i = 0; i < belt.length; i++) 
        {
            if (belt[i] == 0) 
            {
                cnt++;
            }
            if (cnt >= K)
                return false;
        }
        return true;
    }
}

