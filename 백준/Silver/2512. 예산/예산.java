import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int r = 0;
        int l = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budgets = new int[N];
        for(int i = 0; i < N; i++) {
        	budgets[i] = Integer.parseInt(st.nextToken());
        	
        	if(budgets[i] > r) r = budgets[i];
        }
        int total = Integer.parseInt(br.readLine());
        
        while(l <= r) {
        	int mid = (l + r) / 2;
        	
        	int sum = 0;
        	for(int i = 0; i < N; i++) {
        		if(budgets[i] > mid) sum += mid;
        		else sum += budgets[i];
        	}
        	
        	if(sum <= total) l = mid + 1;
        	else r = mid - 1;
        }
        
        System.out.println(r);
	}
}