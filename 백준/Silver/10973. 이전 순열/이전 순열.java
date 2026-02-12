import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        if (!nextPermutation(a)) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(a[i]);
            if (i + 1 < N) sb.append(' ');
        }
        System.out.println(sb);
    }

    static boolean nextPermutation(int[] a) {
        int n = a.length;

        int i = n - 1;
        while (i > 0 && a[i - 1] <= a[i]) i--;
        if (i == 0) return false; // 마지막 순열

        int j = n - 1;
        while (a[j] >= a[i - 1]) j--;

        swap(a, i - 1, j);

        int l = i, r = n - 1;
        while (l < r) swap(a, l++, r--);

        return true;
    }

    static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}