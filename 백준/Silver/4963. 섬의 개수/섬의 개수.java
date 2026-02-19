import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;    
            
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
        
            int answer = 0;
            Stack<Pair> s = new Stack<>();
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 0 || (map[i][j] == 1 && visited[i][j])) continue;
                    
                    visited[i][j] = true;
                    s.add(new Pair(i, j));
                    while(!s.isEmpty()) {
                        Pair cur = s.pop();
                        
                        for(int dir = 0; dir < 8; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            
                            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                            if(visited[nx][ny] || map[nx][ny] == 0) continue;
                            
                            visited[nx][ny] = true;
                            s.add(new Pair(nx, ny));
                        }
                    }
                    
                    answer++;
                }
            }
            
            bw.write("" + answer + "\n");
        }
        
        bw.close();
    }
}

class Pair {
    int x, y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}