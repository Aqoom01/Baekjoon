import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Pos[] posList = new Pos[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            posList[i] = new Pos(x, y);
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            sum += posList[i].x * posList[next].y - posList[i].y * posList[next].x;
        }

        double answer = Math.abs(sum) / 2.0;
        System.out.printf("%.1f\n", answer);
    }
}

class Pos {
    long x, y;

    Pos(long x, long y) {
        this.x = x;
        this.y = y;
    }
}