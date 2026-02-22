import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for(int j = 0; j < N; j++) map[i][j] = input.charAt(j);
        }
        StringBuilder sb = new StringBuilder();
        
        // 적록색약이 아닌 사람
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(visited[i][j]) continue;
        	
        		char cri = map[i][j];
        		Queue<Pair> q = new ArrayDeque<>();
        		visited[i][j] = true;
        		q.offer(new Pair(i, j));
        		while(!q.isEmpty()) {
        			Pair cur = q.poll();
        			
        			for(int dir = 0; dir < 4; dir++) {
        				int nx = cur.x + dx[dir];
        				int ny = cur.y + dy[dir];
        				
        				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        				if(map[nx][ny] != cri) continue;
        				if(visited[nx][ny]) continue;
        			
        				visited[nx][ny] = true;
        				q.offer(new Pair(nx, ny));
        			}
        		}
        		
        		cnt++;
        	}        	
        }
        sb.append(cnt).append(" ");
        
        // 적록색약
        cnt = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(visited[i][j]) continue;
        	
        		char cri = map[i][j];
        		Queue<Pair> q = new ArrayDeque<>();
        		visited[i][j] = true;
        		q.offer(new Pair(i, j));
        		while(!q.isEmpty()) {
        			Pair cur = q.poll();
        			
        			for(int dir = 0; dir < 4; dir++) {
        				int nx = cur.x + dx[dir];
        				int ny = cur.y + dy[dir];
        				
        				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        				if(visited[nx][ny]) continue;
        				if((cri == 'R' || cri == 'G') && (map[nx][ny] == 'B')) continue;
        				if((cri == 'B') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) continue;
        				
        				visited[nx][ny] = true;
        				q.offer(new Pair(nx, ny));
        			}
        		}
        		
        		cnt++;
        	}        	
        }
        sb.append(cnt);
        
        System.out.println(sb.toString());
	}
}

class Pair {
	int x, y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}