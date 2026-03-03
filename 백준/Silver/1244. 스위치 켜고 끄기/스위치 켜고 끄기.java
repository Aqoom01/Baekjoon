import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] arr;
	static int m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//---------솔루션 코드를 작성하세요.
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1) {
				int cur_idx = b-1;
				while(cur_idx<n) {
					arr[cur_idx]^=1;
					cur_idx+=b;
				}
			}
			else {
				int cur_idx = b - 1;
				arr[cur_idx]^=1;
				int interval = 1;
				while(cur_idx-interval>=0&&cur_idx+interval<n) {
					if(arr[cur_idx-interval]==arr[cur_idx+interval]) {
						arr[cur_idx-interval]^=1;
						arr[cur_idx+interval]^=1;
						interval++;
					}
					else
						break;
				}
			}
		}
		int cnt = 0;
		for(int i =0;i<n;i++) {
			if(cnt==20) {
				cnt = 0;
				System.out.println();
			}
			System.out.print(arr[i]+" ");
			cnt++;
		}

	}

}
