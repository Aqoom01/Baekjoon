import java.io.*;
import java.util.*;

class Solution
{
	static int[] arr;
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int t = 1; t <= T; t++) {
    		StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
    		
    		arr = new int[10];
    		int N = Integer.parseInt(br.readLine());
    		int cnt = 1;
    		int answer = N;
    		while(!check()) {
    			answer = N * cnt++;
    			divide(answer);
    		}
    		
    		bw.write(sb.append(answer) + "\n");
    	}
    	bw.close();
    }
    
    private static void divide(int N) {
    	while(N != 0) {
    		arr[N % 10]++;
    		N /= 10;
    	}
    }
    
    private static boolean check() {
    	for(int i = 0; i < 10; i++) {
    		if(arr[i] == 0) return false;
    	}
    	return true;
    }
}