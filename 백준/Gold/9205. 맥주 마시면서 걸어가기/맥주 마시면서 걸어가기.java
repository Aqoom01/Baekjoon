import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	int T = readInt();
    	for(int t = 1; t <= T; t++) {
    		int n = readInt();
    		Pos[] posList = new Pos[n + 2];
    		int[][] graph = new int[n + 2][n + 2];
    		
    		for(int i = 0; i < n + 2; i++) {
    			Pos pos = new Pos(readInt(), readInt());
    			posList[i] = pos;
    		}
    		
    		boolean[] visited = new boolean[n + 2];
    		visited[0] = true;
    		Deque<Integer> q = new ArrayDeque<>();
    		q.offer(0);
    		while(!q.isEmpty()) {
    			int curIndex = q.poll();
    			if(curIndex == n + 1) break;
    			
    			for(int i = 0; i < n + 2; i++) {
    				
    				if(i == curIndex) continue;
    				if(visited[i]) continue;
    				if(Math.abs(posList[curIndex].x - posList[i].x) + Math.abs(posList[curIndex].y - posList[i].y) <= 1000) {
    					visited[i] = true;
    					q.offer(i);
    				}
    			}
    		}
    		
    		System.out.println(visited[n + 1] ? "happy" : "sad");
    	}
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

class Pos {
	int x, y;
	
	Pos(int x, int y) { this.x = x; this.y = y; }
}