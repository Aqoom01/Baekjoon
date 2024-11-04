import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();

        StringTokenizer stA = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A.add(Integer.parseInt(stA.nextToken()));
        }

        StringTokenizer stB = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            B.add(Integer.parseInt(stB.nextToken()));
        }

        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        int S = 0;
        for(int i = 0; i < N; i++) {
            S += A.get(i) * B.get(i);
        }
        System.out.println(S);
    }
}