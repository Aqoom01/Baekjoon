import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		for(int i = 1; i <= V; i++) parent[i] = i;
	
		List<Edge> edges = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a, b, c));
		}
		edges.sort((e1, e2) -> e1.cost - e2.cost);
		
		int answer = 0;
		int count = 0;
		for(int i = 0; i < edges.size(); i++) {
			if(count == V - 1) continue;
			
			Edge now = edges.get(i);
			if(find(now.vertex1) != find(now.vertex2)) {
				count++;
				answer += now.cost;
				union(now.vertex1, now.vertex2);
			}
		}
		
		System.out.println(answer);
	}
	
	static void union(int x, int y) {
		int xHead = find(x);
		int yHead = find(y);
		
		parent[yHead] = xHead;
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
}

class Edge {
	int vertex1, vertex2, cost;
	
	Edge(int v1, int v2, int cost) {
		this.vertex1 = v1;
		this.vertex2 = v2;
		this.cost = cost;
	}
}