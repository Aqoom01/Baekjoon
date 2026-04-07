import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        long prefix = dp[0];
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2] + 2 * prefix) % MOD;
            prefix = (prefix + dp[i - 2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}