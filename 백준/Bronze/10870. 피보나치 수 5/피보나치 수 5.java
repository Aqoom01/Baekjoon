import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        if(N <= 1) {
            bw.write("" + N);   
        }
        else {
            int[] fib = new int[N + 1];
            fib[0] = 0;
            fib[1] = 1;
            
            for(int i = 2; i <= N; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            
            bw.write("" + fib[N]);
        }
        
        bw.flush();
        bw.close();
    }
}