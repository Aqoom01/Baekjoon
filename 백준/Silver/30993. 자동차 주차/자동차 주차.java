import java.io.*;
import java.util.*;

public class Main {
	static int[] counts = new int[3];
	static int N;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < counts.length; i++) counts[i] = Integer.parseInt(st.nextToken());
		
		countAll(0);
		
		System.out.println(answer);
	}
	
	private static void countAll(int depth) {
		if(depth == N) {
			answer++;
			return;
		}
		for(int i = 0; i < 3; i++) {
			if(counts[i] == 0) continue;
			
			counts[i]--;
			countAll(depth + 1);
			counts[i]++;
		}
	}
}