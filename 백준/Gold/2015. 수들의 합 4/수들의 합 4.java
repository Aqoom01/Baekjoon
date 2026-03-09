import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Long, Long> map = new HashMap<>();

        long prefix = 0;
        long answer = 0;

        map.put(0L, 1L);

        for(int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());

            prefix += num;

            if(map.containsKey(prefix - K)) {
                answer += map.get(prefix - K);
            }

            map.put(prefix, map.getOrDefault(prefix, 0L) + 1);
        }

        System.out.println(answer);
    }
}