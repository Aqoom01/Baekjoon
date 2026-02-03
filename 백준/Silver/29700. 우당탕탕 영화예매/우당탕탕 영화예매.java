import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = inputs[j] - '0';
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M - K + 1; j++) {
                int sum = 0;
                for(int k = 0; k < K; k++) {
                	sum += map[i][j + k];
                }
                
                if(sum == 0) cnt++;
            }
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
	}
}