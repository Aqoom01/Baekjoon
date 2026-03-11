import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int answer = 0;
        while(true) {
        	boolean flag = false;
        	boolean[][] visited = new boolean[N][N];
        	
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			if(visited[i][j]) continue;
        			
        			visited[i][j] = true;
        			List<Pos> l = new ArrayList<>();
        			Queue<Pos> q = new ArrayDeque<>();
        			l.add(new Pos(i, j));
        			q.offer(new Pos(i, j));
        			int sum = 0;
        			int cnt = 0;
        			while(!q.isEmpty()) {
        				Pos cur = q.poll();
        				
        				sum += map[cur.x][cur.y];
        				cnt++;
        				
        				for(int dir = 0; dir < 4; dir++) {
        					int nx = cur.x + dx[dir];
        					int ny = cur.y + dy[dir];
        					
        					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        					if(visited[nx][ny]) continue;
        					if(Math.abs(map[cur.x][cur.y] - map[nx][ny]) < L || Math.abs(map[cur.x][cur.y] - map[nx][ny]) > R) continue;
        					
        					Pos c = new Pos(nx, ny);
        					flag = true;
        					visited[nx][ny] = true;
        					q.offer(c);
        					l.add(c);
        				}
        			}
        			
        			int val = sum / cnt;
        			for(Pos p : l) map[p.x][p.y] = val;
        		}
        	}

			if(!flag) break;
        	answer++;
        }
        
        System.out.println(answer);
    }
}

class Pos {
	int x, y;
	
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}