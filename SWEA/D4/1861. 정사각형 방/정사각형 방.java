import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int t = 1; t <= T; t++) {
    		StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
    		
    		int N = Integer.parseInt(br.readLine());
    		int[][] map = new int[N][N];
    		for(int i = 0; i < N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < N; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		
    		int maxLength = Integer.MIN_VALUE;
    		int start = 100000;    		
    		Queue<Pair> q = new ArrayDeque<>();
    		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) {
    			q.offer(new Pair(i, j, 1));
    			
    			int temp_Length = -1;
    			int[] temp_start = new int[2];
    			while(!q.isEmpty()) {
    				Pair cur = q.poll();
    				
    				if(temp_Length < cur.depth) {
    					temp_Length = cur.depth;
    					temp_start = new int[]{cur.x, cur.y};
    				}
    				else if(temp_Length == cur.depth) {
    					if(map[temp_start[0]][temp_start[1]] > map[cur.x][cur.y]) {
    						temp_start[0] = cur.x;
    						temp_start[1] = cur.y;
    					}
    				}
    				
    				for(int dir = 0; dir < 4; dir++) {
    					int nx = cur.x + dx[dir];
    					int ny = cur.y + dy[dir];
    					
    					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
    					if(map[nx][ny] != map[cur.x][cur.y] - 1) continue;
    					
    					q.add(new Pair(nx, ny, cur.depth + 1));
    				}
    			}
    			
    			if(temp_Length > maxLength) {
					maxLength = temp_Length;
					start = map[temp_start[0]][temp_start[1]];
				}
				else if(temp_Length == maxLength) {
					if(map[temp_start[0]][temp_start[1]] < start) start = map[temp_start[0]][temp_start[1]];
				}
    		}
    		
    		sb.append(start).append(" ").append(maxLength).append("\n");
    		bw.write(sb.toString());
    	}
    	bw.close();
    }
}

class Pair {
	int x, y, depth;
	
	Pair(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}