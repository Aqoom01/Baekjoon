import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = readInt();
        int M = readInt();

        문제[] 문제집 = new 문제[N + 1];
        for (int i = 1; i <= N; i++) 문제집[i] = new 문제(i);

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int before = readInt();
            int after = readInt();

            문제집[before].after.add(after);
            indegree[after]++;
        }

        PriorityQueue<문제> pq = new PriorityQueue<>((a, b) -> a.id - b.id);

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) pq.offer(문제집[i]);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            문제 cur = pq.poll();
            sb.append(cur.id).append(' ');

            for (int next : cur.after) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(문제집[next]);
                }
            }
        }

        System.out.print(sb);
    }

    static int readInt() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32);
        int n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class 문제 {
    int id;
    List<Integer> after;

    문제(int id) {
        this.id = id;
        this.after = new ArrayList<>();
    }
}