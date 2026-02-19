import java.io.*;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	int[][] map = new int[N][N];
        	List<Pair> start = new ArrayList<Pair>(); 

        	answer = 0;
        	int max = -1; 
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			
        			if(map[i][j] > max) { 
        				start.clear(); 
        				start.add(new Pair(i, j, 1)); 
        				max = map[i][j]; 
    				} 
        			else if(map[i][j] == max) start.add(new Pair(i, j, 1)); 
    			}
        	}
        	
        	dfs(N, map, start);
        	
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			for(int k = 1; k <= K; k++) {
        				map[i][j] -= k;
                		dfs(N, map, start);
                		map[i][j] += k;
        			}
        		}
        	}
        	
        	bw.write(sb.append(answer).append("\n").toString());
        }
        
        bw.close();
    }
    
    static void dfs(int N, int[][] map, List<Pair> start) {
    	Stack<Pair> s = new Stack<>();
    	for(int i = 0; i < start.size(); i++) {
    		s.add(start.get(i));
    		
    		int temp = 0;
    		while(!s.isEmpty()) { 
    			Pair cur = s.pop(); 
    			temp = Math.max(temp, cur.depth); 
    			
    			for(int dir = 0; dir < 4; dir++) { 
    				int nx = cur.x + dx[dir]; 
    				int ny = cur.y + dy[dir]; 
    				
    				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; 
    				if(map[nx][ny] >= map[cur.x][cur.y]) continue; 
    				
    				s.add(new Pair(nx, ny, cur.depth + 1)); 
				} 
			} 
    		
    		answer = Math.max(answer, temp); 
    	} 
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