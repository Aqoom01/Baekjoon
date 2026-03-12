import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static Pos com, hom, node[];
	static boolean[] visited;
	static int[] output;
	static int answer;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
        	N = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	com = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	hom = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	node = new Pos[N];
        	
        	int idx = 0;
        	while(st.hasMoreTokens()) node[idx++] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	
        	answer = Integer.MAX_VALUE;
        	visited = new boolean[N];
        	output = new int[N];
        	countAll(0);
        	
        	sb.append(answer);
        	System.out.println(sb.toString());
        }
    }
	
	static void countAll(int cursor) {
		if(cursor == N) {
			answer = Math.min(answer, getDist());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			output[cursor] = i;
			countAll(cursor + 1);
			visited[i] = false;
		}
	}
	
	static int getDist() {
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			Pos prev, cur = node[output[i]];
			if(i == 0) prev = com;
			else prev = node[output[i - 1]];
			
			sum += Math.abs(cur.r - prev.r) + Math.abs(cur.c - prev.c);
		}
		sum += Math.abs(node[output[N - 1]].r - hom.r) + Math.abs(node[output[N - 1]].c - hom.c);
		
		return sum;
	}
}

class Pos {
	int r, c;
	
	Pos(int r, int c) { this.r = r; this.c = c; }
}