import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j  = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Pair> s = new Stack<>();
        s.add(new Pair(0, 0));
        visited[0][0] = true;
        while(!s.isEmpty()) {
            Pair cur = s.pop();
            if(cur.x == N - 1 && cur.y == N - 1) {
                System.out.println("HaruHaru");
                return;
            }
            
            for(int dir = 0; dir < 2; dir++) {
                int nx = cur.x + map[cur.x][cur.y] * dx[dir];
                int ny = cur.y + map[cur.x][cur.y] * dy[dir];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                s.add(new Pair(nx, ny));
            }
        }
        
        System.out.println("Hing");
    }
}

class Pair {
    int x, y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}