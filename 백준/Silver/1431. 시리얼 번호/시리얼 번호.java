import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	String[] str = new String[N];
    	for(int i = 0; i < N; i++) str[i] = br.readLine();
    	
    	Arrays.sort(str, (a, b) -> {
    		if(a.length() != b.length()) return a.length() - b.length();
    		else {
    			int a_sum = 0;
    			int b_sum = 0;
    			
    			for(int i = 0; i < a.length(); i++) if(a.charAt(i) >= '0' && a.charAt(i) <= '9') a_sum += a.charAt(i) - '0';
    			for(int i = 0; i < b.length(); i++) if(b.charAt(i) >= '0' && b.charAt(i) <= '9') b_sum += b.charAt(i) - '0';
    			
    			if(a_sum != b_sum) return a_sum - b_sum;
    			else return a.compareTo(b);
    		}
    	});
    	
    	for(int i = 0; i < str.length; i++) {
    		System.out.println(str[i]);
    	}
    }
}