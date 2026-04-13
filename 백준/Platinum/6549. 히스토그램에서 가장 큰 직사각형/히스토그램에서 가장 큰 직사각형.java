import java.io.*;
import java.util.*;

public class Main {
    static Deque<Node> s;
    static long answer;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            s = new ArrayDeque<>();
            answer = 0;
            index = 0;

            for (int i = 0; i < n; i++) {
                int height = Integer.parseInt(st.nextToken());
                add(height);
            }

            add(0); // 남은 막대 처리
            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }

    private static void add(int height) {
        int start = index;

        while (!s.isEmpty() && s.peekLast().height > height) {
            Node prev = s.removeLast();
            answer = Math.max(answer, prev.height * (index - prev.idx));
            start = prev.idx;
        }

        if (s.isEmpty() || s.peekLast().height < height) {
            s.addLast(new Node(start, height));
        }

        index++;
    }
}

class Node {
    int idx;
    long height;

    Node(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}