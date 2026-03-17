import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] schools = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			if(st.nextToken().equals("M")) schools[i] = 1;
			else schools[i] = 0;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(schools[v1] != schools[v2]) pq.add(new Edge(v1, v2, cost));
		}
		
		int[] parent = new int[N + 1];
		for(int i = 1; i <= N; i++) parent[i] = i;
		
		int answer = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(findParent(parent, cur.v1) == findParent(parent, cur.v2)) continue;
			
			union(parent, cur.v1, cur.v2);
			answer += cur.cost;
			count++;
		}
		
		System.out.println(count == N - 1 ? answer : -1);
	}
	
	static int findParent(int[] parent, int a) {
		if(parent[a] == a) return a;
		return parent[a] = findParent(parent, parent[a]);
	}
	
	static void union(int[] parent, int a, int b) {
		int aHead = findParent(parent, a);
		int bHead = findParent(parent, b);
		
		parent[aHead] = bHead;
	}
}

class Edge {
	int v1, v2, cost;
	
	Edge(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
}