import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[31];
		dp[0] = 1;
		for(int i = 2; i <= 30; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for(int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
		}
		
		System.out.println(dp[N]);
	}
}