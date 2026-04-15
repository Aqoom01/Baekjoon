import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
	
    static int[][] map;
    static int[][] dp;
	public static void main(String[] args) throws IOException {
    	int M = readInt();
    	int N = readInt();
    	
    	map = new int[M][N];
    	for(int i = 0; i < M; i++) for(int j = 0; j < N; j++) {
    		map[i][j] = readInt();
    	}
    	dp = new int[M][N];
    	for(int i = 0; i < M; i++) Arrays.fill(dp[i], -1);
    	
    	System.out.println(dfs(0, 0));
    }
	
	private static int dfs(int r, int c) {
		if(r == map.length - 1 && c == map[0].length - 1) return 1;
		
		if(dp[r][c] == -1) {
			int retVal = 0;
			for(int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) continue;
				if(map[nr][nc] >= map[r][c]) continue;
				
				retVal += dfs(nr, nc);
			}
			return dp[r][c] = retVal;
		}
		return dp[r][c];
	}
    
    private static int readInt() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32);

        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }

        int n = c - '0';
        while ((c = System.in.read()) > 32) {
            n = n * 10 + (c - '0');
        }

        return n * sign;
    }
}