import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];

        int maxW = 0, maxH = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if (dir[i] == 1 || dir[i] == 2) {
                maxW = Math.max(maxW, len[i]);
            } else {
                maxH = Math.max(maxH, len[i]);
            }
        }

        int smallW = 0, smallH = 0;

        for (int i = 0; i < 6; i++) {
            if (dir[i] == dir[(i + 2) % 6] &&
                dir[(i + 1) % 6] == dir[(i + 3) % 6]) {
                smallW = len[(i + 1) % 6];
                smallH = len[(i + 2) % 6];
                break;
            }
        }

        int area = (maxW * maxH) - (smallW * smallH);
        System.out.println(area * K);
    }
}