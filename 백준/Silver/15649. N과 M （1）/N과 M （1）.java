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
        perm(N, M, result, visited, 0);
        
        bw.flush();
        bw.close();
    }
    
    private static void perm(int N, int M, int[] result, boolean[] visited, int depth) throws IOException {
        if(depth == M) {
        	StringBuilder sb = new StringBuilder();
        	for(int i : result) sb.append(i + " ");
        	
        	bw.write(sb.toString() + "\n");
        }
        else {
        	for(int i = 1; i <= N; i++) {
        		if(visited[i]) continue;
        		
        		result[depth] = i;
        		visited[i] = true;
        		perm(N, M, result, visited, depth + 1);
        		visited[i] = false;
        	}
        }
    }
}