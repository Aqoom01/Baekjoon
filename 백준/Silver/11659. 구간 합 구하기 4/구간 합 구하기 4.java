import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(prefix[end] - prefix[start - 1]);
        }
    }
}
