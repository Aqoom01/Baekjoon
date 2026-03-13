import java.io.*;
import java.util.*;

public class Main {	
	static long[] nums, tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		nums = new long[N];
		for(int i = 0; i < N; i++) nums[i] = Long.parseLong(br.readLine());
		
		tree = new long[getTreeSize(N)];
		init(0, N - 1, 1);
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "1":
				int idx = Integer.parseInt(st.nextToken()) - 1;
				long value = Long.parseLong(st.nextToken());
				
				long diff = value - nums[idx];
				update(0, N - 1, 1, idx, diff);
				
				nums[idx] = value;
				break;
			case "2":
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				
				sb.append(pSum(0, N - 1, 1, l, r) + "\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static int getTreeSize(int N) {
		int h = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
		return (int) Math.pow(2, h);
	}
	
	static long init(int start, int end, int node) {
		if(start == end) return tree[node] = nums[start];
		
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
	
	static void update(int start, int end, int node, int idx, long diff) {
		if(start <= idx && idx <= end) {
			tree[node] += diff;
		} else return;
		
		if(start == end) return;
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);
	}
	
	static long pSum(int start, int end, int node, int l, int r) {
		if(r < start || l > end) return 0;
		if(l <= start && end <= r) return tree[node];
		
		int mid = (start + end) / 2;
		return pSum(start, mid, node * 2, l, r) + pSum(mid + 1, end, node * 2 + 1, l, r);
	}
}