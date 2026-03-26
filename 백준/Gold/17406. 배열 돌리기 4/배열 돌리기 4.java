import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] origin;
    static Rotate[] ops;
    static boolean[] selected;
    static int[] order;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        origin = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ops = new Rotate[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            ops[i] = new Rotate(r, c, s);
        }

        selected = new boolean[K];
        order = new int[K];

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == K) {
            int[][] copied = copyArray(origin);

            for (int i = 0; i < K; i++) {
                applyRotate(copied, ops[order[i]]);
            }

            answer = Math.min(answer, getMinRowSum(copied));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            order[depth] = i;
            dfs(depth + 1);
            selected[i] = false;
        }
    }

    private static int[][] copyArray(int[][] arr) {
        int[][] copied = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copied[i][j] = arr[i][j];
            }
        }
        return copied;
    }

    private static void applyRotate(int[][] arr, Rotate op) {
        int r = op.r;
        int c = op.c;
        int s = op.s;

        for (int layer = 1; layer <= s; layer++) {
            rotateLayer(arr, r - layer, c - layer, r + layer, c + layer);
        }
    }

    private static void rotateLayer(int[][] arr, int top, int left, int bottom, int right) {
        List<Pos> pos = new ArrayList<>();

        for (int j = left; j < right; j++) pos.add(new Pos(top, j));
        for (int i = top; i < bottom; i++) pos.add(new Pos(i, right));
        for (int j = right; j > left; j--) pos.add(new Pos(bottom, j));
        for (int i = bottom; i > top; i--) pos.add(new Pos(i, left));

        int lastR = pos.get(pos.size() - 1).r;
        int lastC = pos.get(pos.size() - 1).c;
        int lastValue = arr[lastR][lastC];

        for (int k = pos.size() - 1; k >= 1; k--) {
            Pos cur = pos.get(k);
            Pos prev = pos.get(k - 1);
            arr[cur.r][cur.c] = arr[prev.r][prev.c];
        }

        Pos first = pos.get(0);
        arr[first.r][first.c] = lastValue;
    }

    private static int getMinRowSum(int[][] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}

class Rotate {
    int r, c, s;

    Rotate(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

class Pos {
	int r, c; 
	
	Pos(int r, int c) { this.r = r; this.c = c; }
}