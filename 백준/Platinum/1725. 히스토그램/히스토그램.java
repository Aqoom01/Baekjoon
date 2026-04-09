import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] h = new long[N + 1]; // 마지막 0 추가용
        for (int i = 0; i < N; i++) {
            h[i] = Long.parseLong(br.readLine());
        }
        h[N] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        long answer = 0;

        for (int i = 0; i <= N; i++) {
            while (!stack.isEmpty() && h[stack.peekLast()] > h[i]) {
                long height = h[stack.removeLast()];
                long width;

                if (stack.isEmpty()) width = i;
                else width = i - stack.peekLast() - 1;

                answer = Math.max(answer, height * width);
            }
            stack.addLast(i);
        }

        System.out.println(answer);
    }
}