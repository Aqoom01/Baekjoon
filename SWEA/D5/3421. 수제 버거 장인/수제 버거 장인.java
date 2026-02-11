import java.io.*;
import java.util.*;

public class Solution {
	static int ans;
	static int N;
	
	static boolean[][] graph;
	static Integer[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	graph = new boolean[N][N];
        	for(int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken()) - 1;
        		int b = Integer.parseInt(st.nextToken()) - 1;
        		
        		graph[a][b] = true;
        		graph[b][a] = true;
        	}
        	
        	ans = 0;
        	arr = new Integer[N];
        	dfs(0);
        	
        	bw.write(sb.append(ans).append("\n").toString());
        }        
        bw.close();
    }
    
    private static void dfs(int depth) {
    	if(depth == N) {
    		ans++;
    		return;
    	}
    	
    	boolean canAdd = true;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] != null) if(graph[i][depth]) canAdd = false;
    	}
    	
    	if(!canAdd) dfs(depth + 1);
    	else {
    		arr[depth] = depth;
    		dfs(depth + 1);
    		
    		arr[depth] = null;
    		dfs(depth + 1);
    	}
    }
}