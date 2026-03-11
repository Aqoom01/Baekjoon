import java.io.*;
import java.util.*;

public class Main {
	static List<Cam> cctv;
	static int[][][][] directions = new int[][][][] {
		{},
		{
			{
				{1, 0}
			},
			{
				{0, 1}
			},
			{
				{-1, 0}				
			},
			{
				{0, -1}
			}
		},
		{
			{
				{1, 0}, {-1, 0}
			},
			{
				{0, 1}, {0, -1}
			},
			{
				{1, 0}, {-1, 0}
			},
			{
				{0, 1}, {0, -1}
			}
		},
		{
			{
				{1, 0}, {0, 1}
			},
			{
				{0, 1}, {-1, 0} 
			},
			{
				{-1, 0}, {0, -1}
			},
			{
				{0, -1}, {1, 0}
			}
		},
		{
			{
				{-1, 0}, {0, -1}, {1, 0}
			},
			{
				{0, -1}, {1, 0}, {0, 1}
			},
			{
				{-1, 0}, {1, 0}, {0, 1}
			},
			{
				{-1, 0}, {0, -1}, {0, 1}
			}
		},
		{
			{
				{-1, 0}, {0, -1}, {1, 0}, {0, 1}
			},
			{
				{-1, 0}, {0, -1}, {1, 0}, {0, 1}
			},
			{
				{-1, 0}, {0, -1}, {1, 0}, {0, 1}
			},
			{
				{-1, 0}, {0, -1}, {1, 0}, {0, 1}
			}
		}
	};
	static int N, M;
	static int[][] map;
	static int[] output;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cctv = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new Cam(i, j, map[i][j]));
				}
			}
		}
		
		output = new int[cctv.size()];
		answer = Integer.MAX_VALUE;
		dfs(0);
		
		System.out.println(answer);
	}
	
	static void dfs(int cursor) {
		if(cursor == cctv.size()) {
			answer = Math.min(countBlind(), answer);
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			output[cursor] = dir;
			dfs(cursor + 1);
		}
	}
	
	static int countBlind() {
		int[][] temp = new int[N][M];
		for(int i = 0; i < N; i++) temp[i] = map[i].clone();
		
		for(int i = 0; i < cctv.size(); i++) {
			Cam current = cctv.get(i);
			
			int[][] dir = directions[current.type][output[i]];
			for(int j = 0; j < dir.length; j++) {
				int curX = current.r;
				int curY = current.c;
				while(true) {
					int nx = curX + dir[j][0];
					int ny = curY + dir[j][1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
					if(temp[nx][ny] == 6) break;
					
					temp[nx][ny] = -1;
					curX = nx;
					curY = ny;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) {
			if(temp[i][j] == 0) cnt++;
		}
		
		return cnt;
	}
}

class Cam {
	int r, c, type, dir;
	
	Cam(int r, int c, int type) {
		this.r = r;
		this.c = c;
		this.type = type;
	}
}