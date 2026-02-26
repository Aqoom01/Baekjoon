import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 2};
    static int[] dp = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dp[N] = 1;
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            Set<Integer> addInt = new HashSet<>();
            
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                if(cur == K) {
                    System.out.println(step);
                    System.out.println(dp[cur]);
                    return;
                }
            
                for(int dir = 0; dir < 3; dir++) {
                    int nx = -1;
                    if(dir == 2) nx = cur * dx[dir];
                    else nx = cur + dx[dir];
                    
                    if(nx < 0 || nx > 100000) continue;
                    if(addInt.contains(nx)) dp[nx] += dp[cur];
                    else if(dp[nx] != 0) continue;
                    else {
                        addInt.add(nx);
                        q.offer(nx);
                        dp[nx] = dp[cur];
                    }
                }
            }
            
            step++;
        }
    }
}