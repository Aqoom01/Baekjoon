import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, C;
    static int[][] a;
    static int[][] best;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            a = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            best = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {
                    int[] seg = new int[M];
                    for (int k = 0; k < M; k++) seg[k] = a[r][c + k];
                    best[r][c] = maxProfitInSegment(seg);
                }
            }

            ans = 0;
            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    int p1 = best[r1][c1];

                    for (int r2 = r1; r2 < N; r2++) {
                        int startC2 = 0;
                        if (r2 == r1) startC2 = c1 + M;
                        for (int c2 = startC2; c2 <= N - M; c2++) {
                            int p2 = best[r2][c2];
                            ans = Math.max(ans, p1 + p2);
                        }
                    }
                }
            }

            out.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(out.toString());
    }

    static int maxProfitInSegment(int[] seg) {
        return subsetDfs(seg, 0, 0, 0);
    }

    static int subsetDfs(int[] seg, int idx, int sum, int profit) {
        if (sum > C) return 0;
        if (idx == seg.length) return profit;

        int best1 = subsetDfs(seg, idx + 1, sum, profit);

        int v = seg[idx];
        int best2 = subsetDfs(seg, idx + 1, sum + v, profit + v * v);

        return Math.max(best1, best2);
    }
}