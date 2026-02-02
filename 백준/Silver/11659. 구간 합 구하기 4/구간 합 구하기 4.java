import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] sumArr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        int idx = 1;
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
            sumArr[idx++] = sum;
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            bw.write(sumArr[j] - sumArr[i - 1] + "\n");
        }
        
        bw.flush();
        bw.close();
	}
}