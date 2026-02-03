import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int s = 0;
		int e = n - 1;
		int sum = Integer.MAX_VALUE;
		int a = 0, b = 0;
		
		while(s < e) {
			int op = arr[s] + arr[e];
			
			if (Math.abs(op) < sum) {
				a = arr[s];
				b = arr[e];
				sum = Math.abs(op);
			}
			if (op == 0) break;
			else if (op < 0) s++;
			else e--;
		}
		
		System.out.printf("%d %d", a, b);
		
	}

}
