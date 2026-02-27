import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] answer = new int[N + 1];
        int[] preCnt = new int[N + 1];
        List<Integer>[] after = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
        	after[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	
        	preCnt[B]++;
        	after[A].add(B);
        }
        
        int cnt = 1;
    	Queue<Integer> q = new ArrayDeque<>();
    	for(int i = 1; i <= N; i++) if(preCnt[i] == 0) {
    		answer[i] = cnt;
    		q.offer(i);
    	}
    	
        while(!q.isEmpty()) {
        	cnt++;
        	
        	int size = q.size();
        	for(int s = 0; s < size; s++) {
            	int cur = q.poll();
        		
        		for(int i = 0; i < after[cur].size(); i++) {
            		int a = after[cur].get(i);
            		
            		preCnt[a]--;
            		if(preCnt[a] == 0) {
            			answer[a] = cnt;
            			q.offer(a);
            		}
            	}
        	}
        }
       
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) sb.append(answer[i]).append(" ");
        
        System.out.println(sb.toString());
	}
}