import java.io.*;
import java.util.*;

public class Main {
	static int[] amounts;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	amounts = new int[N];
    	int r = 0;
    	int l = Integer.MIN_VALUE;
    	for(int i = 0; i < N; i++) {
    		amounts[i] = Integer.parseInt(br.readLine());
    		
    		r += amounts[i];
    		l = Math.max(amounts[i], l);
    	}
    	
    	while(l < r) {    		
    		int mid = (l + r) / 2;
    		int cnt = divideByMid(mid);
    		
    		if(cnt > M) l = mid + 1;
    		else r = mid;
    	}
    	
    	System.out.println(l);
    }
		
	private static int divideByMid(int crit) {
		int cnt = 1;
		
		int temp = 0;
		for(int i = 0; i < amounts.length; i++) {
			if(temp + amounts[i] <= crit) temp += amounts[i];
			else {
				cnt++;
				temp = amounts[i];
			}
		}
		
		return cnt;
	}
}