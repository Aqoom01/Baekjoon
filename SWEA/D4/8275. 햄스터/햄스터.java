import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int X;
    static Condition[] conditions;
    
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	StringBuilder sb = new StringBuilder().append("#").append(t);
            
            // 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            conditions = new Condition[M];
            for(int i = 0; i < M; i++) {
            	st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                conditions[i] = new Condition(start, end, cnt);
            }
            
            List<int[]> cases = new ArrayList<>();
            countAll(cases, new int[N + 1], 1);
            if(cases.size() == 0) sb.append(" ").append("-1");
            else {
            	cases.sort((a, b) -> {
            		if(a[0] != b[0]) return Integer.compare(b[0], a[0]);
            		else {
            			for (int i = 1; i < a.length; i++) {
            		        if (a[i] != b[i]) return Integer.compare(a[i], b[i]);
            		    }
            			return 0;
            		}
            	});
            	
            	for(int j = 1; j < N + 1; j++) {
            		sb.append(" ").append(cases.get(0)[j]);
            	}
            }
            
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void countAll(List<int[]> cases, int[] temp, int depth) {
    	if(depth == N + 1) {
        	cases.add(temp.clone());
            return;
        }
        for(int i = 0; i <= X; i++) {
        	temp[depth] = i;
        	temp[0] += i;
        	
        	if(isPossible(temp, depth)) countAll(cases, temp, depth + 1);
            temp[0] -= i;
        }
    }
    
    private static boolean isPossible(int[] temp, int depth) {
        for(Condition c : conditions) {
        	if(depth == c.end) {
            	int temp_sum = 0;
                for(int j = c.start; j <= c.end; j++) temp_sum += temp[j];
                
                if(temp_sum != c.ans) return false;
            }
        }
        return true;
    }
}

class Condition {
    int start;
    int end;
    int ans;
    
    Condition(int start, int end, int ans) {
    	this.start = start;
        this.end = end;
        this.ans = ans;
    }
}