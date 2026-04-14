import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cntArr = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cntArr[arr[i]]++;
        }

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 저장

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && cntArr[arr[stack.peek()]] < cntArr[arr[i]]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }
}