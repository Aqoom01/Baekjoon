import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Set<Integer> coin = new HashSet<>();
		for(int i = 0; i < n; i++) coin.add(Integer.parseInt(br.readLine()));
		
		int[] dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int step = 1;
		Queue<Integer> q = new ArrayDeque<>();
		for(int c : coin) {
			q.offer(c);
			dp[c] = step;
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				if(cur == k) {
					System.out.println(dp[cur]);
					return;
				}
				
				for(int c : coin) {
					int temp = cur + c;
					
					if(temp > 100000) continue;
					
					if(dp[temp] <= step + 1) continue;
					else {
						dp[temp] = step + 1;
						q.offer(temp);
					}
				}
			}
			
			step++;
		}
		
		System.out.println(-1);
	}
}
