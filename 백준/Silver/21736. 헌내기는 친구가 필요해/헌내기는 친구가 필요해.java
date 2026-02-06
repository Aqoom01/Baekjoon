import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[][] map = new String[N][M];
        boolean[][] visited = new boolean[N][M];
        Pair start = new Pair();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = "" + input.charAt(j);
                if(map[i][j].equals("I")) {
                    start.x = i;
                    start.y = j;
                }
            }
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        int answer = 0;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            if(map[cur.x][cur.y].equals("P")) answer++;
            
            for(int dir = 0; dir < 4; dir++) {
                int newX = cur.x + dx[dir];
                int newY = cur.y + dy[dir];
                
                if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if(visited[newX][newY] || map[newX][newY].equals("X")) continue;
                
                q.offer(new Pair(newX, newY));
                visited[newX][newY] = true;
            }
        }
        
        bw.write((answer == 0) ? "TT" : "" + answer);
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