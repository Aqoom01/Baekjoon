import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int[] output;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        output = new int[M];
        compute(N, M, 0);
        
        bw.flush();
        bw.close();
    }
    
    private static void compute(int N, int M, int depth) throws IOException {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : output) sb.append(i + " ");
            
            bw.write(sb.toString() + "\n");
        }
        else {
            for(int i = 1; i <= N; i++) {
                output[depth] = i;
                compute(N, M, depth + 1);
            }
        }
    }
}