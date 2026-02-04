import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testcase = 0;
        while(++testcase > 0) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            StringBuilder sb = new StringBuilder().append("Problem ").append(testcase).append(": ");
            
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] dist = new int[N][N];
            for(int[] temp : dist) Arrays.fill(temp, Integer.MAX_VALUE - 1);
            dist[0][0] = map[0][0];
            
            Queue<Pair> q = new PriorityQueue<>();
            q.offer(new Pair(0, 0, map[0][0]));
            while(!q.isEmpty()) {
                Pair cur = q.poll();
                if(cur.x == N - 1 && cur.y == N - 1) break;
                
                for(int dir = 0; dir < 4; dir++) {
                    int newX = cur.x + dx[dir];
                    int newY = cur.y + dy[dir];
                    
                    if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                    if(dist[cur.x][cur.y] + map[newX][newY] < dist[newX][newY]) {
                        dist[newX][newY] = dist[cur.x][cur.y] + map[newX][newY];
                        q.offer(new Pair(newX, newY, dist[newX][newY]));
                    }
                }
            }
            
            sb.append(dist[N-1][N-1]);
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class Pair implements Comparable<Pair> {
    int x;
    int y;
    int value = Integer.MAX_VALUE;
    
    Pair(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.value, o.value);
    }
}