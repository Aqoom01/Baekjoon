import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		App[] apps = new App[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) apps[i] = new App(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) apps[i].cost = Integer.parseInt(st.nextToken());
	
		int[] dp = new int[M + 10_000_001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(App app : apps) for(int i = dp.length - 1; i >= app.memory; i--) {
			if(dp[i - app.memory] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - app.memory] + app.cost);
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = M; i < dp.length; i++) answer = Math.min(answer, dp[i]);
		System.out.println(answer);
	}
}

class App {
	int memory, cost;
	
	App(int memory) {
		this.memory = memory;
	}
}