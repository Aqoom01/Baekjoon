import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] W;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        N = readInt();
        W = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = readInt();
            }
        }

        int subsetCount = 1 << (N - 1);   // {2,3,...,N}의 모든 부분집합 개수
        D = new int[N + 1][subsetCount];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(D[i], INF);
        }

        // D[i][∅] = W[i][1]
        for (int i = 2; i <= N; i++) {
            if (W[i][1] != 0) D[i][0] = W[i][1];
        }

        // |A| = 1 ~ N-2
        for (int k = 1; k <= N - 2; k++) {
            for (int A = 0; A < subsetCount; A++) {
                if (Integer.bitCount(A) != k) continue;

                // i != 1 이고 i가 A에 포함되지 않아야 함
                for (int i = 2; i <= N; i++) {
                    if (contains(A, i)) continue;

                    int min = INF;

                    // j ∈ A
                    for (int j = 2; j <= N; j++) {
                        if (!contains(A, j)) continue;
                        if (W[i][j] == 0) continue;

                        int nextA = remove(A, j);
                        if (D[j][nextA] == INF) continue;

                        min = Math.min(min, W[i][j] + D[j][nextA]);
                    }

                    D[i][A] = min;
                }
            }
        }

        // 최종 답: D[1][V-{1}]
        int fullSet = subsetCount - 1;
        int answer = INF;

        for (int j = 2; j <= N; j++) {
            if (W[1][j] == 0) continue;

            int nextA = remove(fullSet, j);
            if (D[j][nextA] == INF) continue;

            answer = Math.min(answer, W[1][j] + D[j][nextA]);
        }

        System.out.println(answer);
    }

    // 집합 A 안에 정점 v가 포함되는지
    // 정점 2~N을 비트 0~N-2에 대응
    static boolean contains(int set, int v) {
        return (set & (1 << (v - 2))) != 0;
    }

    // 집합 A에서 정점 v 제거
    static int remove(int set, int v) {
        return set & ~(1 << (v - 2));
    }

    static int readInt() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32) ;
        int n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}