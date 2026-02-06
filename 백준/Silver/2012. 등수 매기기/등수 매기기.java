import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int realRank = i + 1;
            sum += Math.abs((long)arr[i] - realRank);
        }

        System.out.println(sum);
    }
}
