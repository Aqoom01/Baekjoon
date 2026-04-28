import java.util.*;
import java.io.*;

class Solution {
	int answer, pipe[][], host, N;
	
    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        
        pipe = new int[n][n];
        for(int[] edge : edges) {
            pipe[edge[0] - 1][edge[1] - 1] = edge[2];
            pipe[edge[1] - 1][edge[0] - 1] = edge[2];
        }
        host = infection - 1;
        N = n;
        
        countAll(0, new int[k]);
        
        return answer;
    }
    
    public void countAll(int cursor, int[] output) {
    	if(cursor == output.length) {
    		countInfection(output);
    		return;
    	}
    	
    	for(int type = 1; type <= 3; type++) {
    		if(cursor >= 1 && output[cursor - 1] == type) continue;
    	
    		output[cursor] = type;
    		countAll(cursor + 1, output);
    	}
    }
    
    public void countInfection(int[] output) {
        int[] infected = new int[N];
        infected[host] = 1;
        
    	for(int i = 0; i < output.length; i++) {
    		int type = output[i];
    		
    		Queue<Integer> virus = new ArrayDeque<>();
    		for(int j = 0; j < infected.length; j++) if(infected[j] == 1) virus.add(j);
    	
    		while(!virus.isEmpty()) {
    			int cur = virus.poll();
    			
    			for (int next = 0; next < N; next++) {
                    if (pipe[cur][next] == type && infected[next] == 0) {
                        infected[next] = 1;
                        virus.offer(next);
                    }
                }
    		}
    	}
    	
    	int temp = 0;
    	for(int i : infected) if(i == 1) temp++;
    	
    	answer = Math.max(answer, temp);
    }
}