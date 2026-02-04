import java.io.*;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 0, 0};
    static int[] dy = {0, -1, 1};
    
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int T = 1; T <= 10; T++) {
        	String t = br.readLine();
            StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
        	
            int[][] map = new int[100][100];
            boolean[][] visited = new boolean[100][100];
            int curX = 99;
            int curY = -1;
            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < 100; j++) {
                	map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 2) {
                    	curY = j;
                    }
                }
            }
            
            Stack<Pair> stack = new Stack<>();
            stack.add(new Pair(curX, curY));
            visited[curX][curY] = true;
            int answer = -1;
            while(true) {
            	Pair cur = stack.pop();
                if(cur.x == 0) {
                	answer = cur.y;
                    break;
                }
                
                visited[cur.x][cur.y] = true;
                for(int dir = 0; dir < 3; dir++) {
                	int newX = cur.x + dx[dir];
                    int newY = cur.y + dy[dir];
                    
                    if(newX < 0 || newY < 0 || newX > 99 || newY > 99) continue;
                    if(map[newX][newY] == 0 || visited[newX][newY]) continue;
                    
                    stack.add(new Pair(newX, newY));
                }
            }
            
            bw.write(sb.append(answer).toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class Pair {
    int x;
    int y;
    
    Pair() {}
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}