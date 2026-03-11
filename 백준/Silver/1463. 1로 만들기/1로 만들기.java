import java.io.*;
import java.util.*;

public class Main {	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[X] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(X);
		
		while(dp[1] == Integer.MAX_VALUE) {
			int cur = q.poll();
			
			if(cur % 3 == 0) {
				dp[cur / 3] = Math.min(dp[cur / 3], dp[cur] + 1);
				q.offer(cur / 3);
			}
			if(cur % 2 == 0) {
				dp[cur / 2] = Math.min(dp[cur / 2], dp[cur] + 1);
				q.offer(cur / 2);
			}
			dp[cur - 1] = Math.min(dp[cur - 1], dp[cur] + 1);
			q.offer(cur - 1);
		}
		
		System.out.println(dp[1]);
	}
}