package week5;

import java.io.*;
import java.util.*;
public class 로봇청소기 {
	static int N;
	static int M;
	static int count;
	static int[][] room;
	static boolean[][] cleaned;
	static final int NORTH = 0;
	static final int EAST = 1;
	static final int SOUTH = 2;
	static final int WEST = 3;
	static class Robot
	{
		int r;	// y좌표
		int c;	// x좌표
		int d;	// 바라보는 방향
		int power; // 작동 : 1, 멈춤 :0
		
		public Robot(int r, int c, int d)
		{
			this.r = r;
			this.c = c;
			this.d = d;
			this.power = 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/************** 입력 *******************/
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(y, x, dir);
		
		room = new int[N][M];
		cleaned = new boolean[N][M];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
			{
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/**************************************/
		// 전원이 꺼질 때 까지
		count = 0;
		while (robot.power == 1)
		{
			int curY = robot.r;
			int curX = robot.c;
			// 1. 현재 칸이 아직 청소되지 않은 경우 현재 칸을 청소한다
			if (room[curY][curX] == 0)
			{
				cleanCurrent(curY, curX);
			}
			// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
		}
		System.out.println(count);
	}
	
	static void cleanCurrent(int curY, int curX)
	{
		cleaned[curY][curX] = true;
		count++;
	}
	
	// (1) 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다
	// (2) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
	public void goBack(int curY, int curX, Robot robot) 
	{
		
		int backY = getBackByDirection(curY, curX, robot.d)[0];
		int backX = getBackByDirection(curY, curX, robot.d)[1];
		if (room[backY][backX] == 1)
		{
			robot.power = 0;
			return;
		}
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				int nextY = curY + i;
				int nextX = curX + j;
				if (nextY >= N || nextX >= M) continue;
				if (cleaned[nextY][nextX] == false && room[nextY][nextX] == 0)
				{
					
				}
			}
		}
	}
	
	// 바라보고 있는 방향에 따라 뒤 칸의 좌표를 리턴하는 메소드
	public int[] getBackByDirection(int curY, int curX, int dir)
	{
		int backY = -1;
		int backX = -1;
		int[] coordinates = new int[2];
		if(dir == NORTH) 
		{
			// 북쪽을 바라보고 있다면 -> 뒤 : y좌표 - 1
			backY = curY - 1;
			backX = curX;
		}
		else if(dir == EAST) 
		{
			// 동쪽을 바라보고 있다면 -> 뒤 : x 좌표 - 1
			backY = curY;
			backX = curX - 1;
		}
		else if(dir == SOUTH) 
		{
			// 남쪽을 바라보고 있다면 -> 뒤 : y 좌표 + 1
			backY = curY + 1;
			backX = curX;
		}
		else if(dir == WEST) 
		{
			// 서쪽을 바라보고 있다면 -> 뒤 : x 좌표 + 1
			backY = curY;
			backX = curX + 1;
		}
		coordinates[0] = backY;
		coordinates[1] = backX;
		return coordinates;
	}
	// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
	// (1) 반시계 방향로 90도 회전한다
	// (2) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
	// (3) 1번으로 돌아간다.
	public void rotate() {}

}
