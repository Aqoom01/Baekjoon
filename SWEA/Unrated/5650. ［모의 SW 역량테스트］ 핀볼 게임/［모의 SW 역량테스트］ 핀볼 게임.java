import java.io.*;
import java.util.*;

public class Solution {
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	
	static int[][] blockDir = new int[][] {
		{},
		{ 1, 3, 0, 2 },
		{ 2, 3, 1, 0 },
		{ 2, 0, 3, 1 },
		{ 3, 2, 0, 1 },
		{ 2, 3, 0, 1 }
	};
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int t = 1; t <= T; t++) {
    		StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
    		int score = 0;
    		
    		int N = sc.nextInt();
    		int[][] map = new int[N + 2][N + 2];
    		List<Pair> startList = new ArrayList<>();
    		List<WarmHole>[] warmholes = new ArrayList[11];
    		for(int i = 6; i <= 10; i++) warmholes[i] = new ArrayList<>();
    		
    		for(int i = 0; i < N + 2; i++) Arrays.fill(map[i], 5);
    		for(int i = 1; i <= N; i++) for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == 0) startList.add(new Pair(i, j));
				if(map[i][j] >= 6) warmholes[map[i][j]].add(new WarmHole(i, j));
			}
    		
    		int answer = Integer.MIN_VALUE;
    		for(Pair curStart : startList) {
    			for(int dir = 0; dir < 4; dir++) {
	    			Pair cur = curStart;
	    			
	    			int temp = 0;
	    			int curDir = dir;
	    			do {
//	    				System.out.println("start=(" + curStart.r + "," + curStart.c + " dir: " + dir + "), cur=("
//	    				        + cur.r + "," + cur.c + "), dir=" + curDir);
	    				
	    				int nr = cur.r + dr[curDir];
	    				int nc = cur.c + dc[curDir];
	    				
	    				if(map[nr][nc] == -1) {
	    					break;
	    				}
	    				else if(map[nr][nc] == 0) {
	    					cur = new Pair(nr, nc);
	    				}
	    				else if(map[nr][nc] < 6) {
	    					temp++;
	    					
	    					curDir = blockDir[map[nr][nc]][curDir];
	    					cur = new Pair(nr, nc);
	    				}
	    				else {
	    					for(WarmHole w : warmholes[map[nr][nc]]) {
	    						if(w.r == nr && w.c == nc) continue;
	    						
	    						cur = new Pair(w.r, w.c);
	    					}
	    				}
	    			} while(!(cur.r == curStart.r && cur.c == curStart.c));

	    			answer = Math.max(answer, temp);
	    		}
    			
    		}
    		
    		sb.append(answer);
    		System.out.println(sb.toString());
    	}
	}
}

class WarmHole {
	int r, c;
	
	WarmHole(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Pair {
	int r, c;
	
	Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
}