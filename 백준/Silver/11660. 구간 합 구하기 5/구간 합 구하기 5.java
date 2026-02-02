import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] sumMap = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                sumMap[i][j] = Integer.parseInt(st.nextToken()) + sumMap[i - 1][j] + sumMap[i][j - 1] - sumMap[i - 1][j - 1];
            }
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int answer = sumMap[x2][y2] - sumMap[x1 - 1][y2] - sumMap[x2][y1 - 1] + sumMap[x1 - 1][y1 - 1];
            bw.write(answer + "\n");
        }
        
        bw.flush();
        bw.close();
	}
}