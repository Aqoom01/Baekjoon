import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n + 1][m + 1];
		int[][] prefix = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j + 1] = str.charAt(j) - '0';
			}
		}
		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prefix[i][j] = prefix[i][j - 1] + arr[i][j];
			}
		}
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j + k <= m; j++) {
				if (prefix[i][j + k] - prefix[i][j] == 0) cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
