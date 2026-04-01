import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Line[] arr = new Line[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Line cur = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			arr[i] = cur;
		}
		
		Arrays.sort(arr, (a, b) -> a.from - b.from);
		int[] lis = new int[N];
		lis[0] = 1;
		for(int i = 1; i < N; i++) {
			int max = 0;
			for(int j = i - 1; j >= 0; j--) if(arr[j].to < arr[i].to) {
				max = Math.max(max, lis[j]);
			}
		
			lis[i] = max + 1;
		}
		
		int ans = 0;
		for(int i : lis) ans = Math.max(ans, i);
		System.out.println(N - ans);
	}
}

class Line {
	int from, to;
	
	Line(int from, int to) {
		this.from = from;
		this.to = to;
	}
}