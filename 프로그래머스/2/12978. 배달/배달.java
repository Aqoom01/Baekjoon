import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Edge>[] edges = new List[N + 1];
        for(int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        
        for(int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            
            edges[from].add(new Edge(to, cost));
            edges[to].add(new Edge(from, cost));
        }
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {1, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(dp[cur[0]] < cur[1]) continue;
            
            for(Edge e : edges[cur[0]]) {
                if(dp[e.to] > dp[cur[0]] + e.cost) {
                    dp[e.to] = dp[cur[0]] + e.cost;
                    pq.add(new int[]{e.to, dp[e.to]});
                }
            }
        }
        for(int i : dp) if(i <= K) answer++;

        return answer;
    }
}

class Edge {
    int to, cost;
    
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}