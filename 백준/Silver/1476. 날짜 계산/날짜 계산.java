import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = S;
        while(true) {
            int e = answer % 15 == 0 ? 15 : answer % 15;
            int m = answer % 19 == 0 ? 19 : answer % 19;
            
            if(E == e && M == m) break;
            answer += 28;
        }
        
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}