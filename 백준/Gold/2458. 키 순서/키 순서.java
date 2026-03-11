import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] small;
	static List<Integer>[] tall;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		small = new List[N + 1];
		tall = new List[N + 1];
		for(int i = 1; i <= N; i++) {
			small[i] = new ArrayList<>();
			tall[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			small[b].add(a);
			tall[a].add(b);
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(getSmall(i, new boolean[N + 1]) + getTall(i, new boolean[N + 1]) == N - 1) answer++;
		}
		
		System.out.println(answer);
	}
	
	static int getSmall(int i, boolean[] visited) {
		int cnt = 0;
		
		for(int l : small[i]) {
			if(visited[l]) {
				continue;
			}
			
			visited[l] = true;
			cnt += getSmall(l, visited) + 1;
		}
		
		return cnt;
	}
	
	static int getTall(int i, boolean[] visited) {
		int cnt = 0;
		
		for(int l : tall[i]) {
			if(visited[l]) {
				continue;
			}
			
			visited[l] = true;
			cnt += getTall(l, visited) + 1;
		}
		
		return cnt;
	}
}