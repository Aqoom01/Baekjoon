import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] result = new int[M];
        boolean[] visited = new boolean[N + 1];
        perm(N, M, result, visited, 0, 1);
        
        bw.flush();
        bw.close();
    }
    
    private static void perm(int N, int M, int[] result, boolean[] selected, int depth, int cur) throws IOException {
        if(depth == M) {
        	StringBuilder sb = new StringBuilder();
        	for(int i : result) sb.append(i + " ");
        	
        	bw.write(sb.toString() + "\n");
        }
        else {
        	for(int i = cur; i <= N; i++) {
        		result[depth] = i;
        		selected[i] = true;
        		perm(N, M, result, selected, depth + 1, i + 1);
        		selected[i] = false;
        	}
        }
    }
}