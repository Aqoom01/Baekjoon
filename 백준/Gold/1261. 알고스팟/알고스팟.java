import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		int[][] dp = new int[N][M];
		for(int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[0][0] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		pq.add(new Pair(0, 0, 0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(dp[p.r][p.c] < p.cost) continue;
			
			for(int dir = 0; dir < 4; dir++) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(dp[nr][nc] > dp[p.r][p.c] + map[nr][nc]) {
					dp[nr][nc] = dp[p.r][p.c]+ map[nr][nc];
					pq.add(new Pair(nr, nc, dp[nr][nc]));
				}
			}
		}
		
		System.out.println(dp[N - 1][M - 1]);
	}
}

class Pair {
	int r, c, cost;
	
	Pair(int r, int c, int cost) { this.r = r; this.c = c; this.cost = cost; }
}