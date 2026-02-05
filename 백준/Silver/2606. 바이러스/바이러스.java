import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N];
        for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        visited = new boolean[N];
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int n : graph[cur]) {
                if(visited[n]) continue;
                visited[n] = true;
                q.offer(n);
            }
        }
        
        int cnt = 0;
        for(boolean b : visited) if(!b) cnt++;
        
        bw.write("" + (N - cnt - 1));
        bw.flush();
        bw.close();
    }
}