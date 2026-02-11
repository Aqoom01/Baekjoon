import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int ans = 0;
    	int idx = 7;
    	while(N != 0) {
    		if(N >= (1 << idx)) {
    			N -= (1 << idx);
    			ans++;
    		}
    		
    		idx--;
    	}
    	
    	System.out.println(ans);
    }
}