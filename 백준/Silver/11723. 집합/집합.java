import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int s = 0; // bitmask for 1..20

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    s |= (1 << (x - 1));
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    s &= ~(1 << (x - 1));
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    out.append((s & (1 << (x - 1))) != 0 ? 1 : 0).append('\n');
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    s ^= (1 << (x - 1));
                    break;
                }
                case "all":
                    s = (1 << 20) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }

        System.out.print(out.toString());
    }
}
