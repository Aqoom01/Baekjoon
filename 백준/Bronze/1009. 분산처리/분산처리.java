import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	int multi = a % 10;
        	while(b-- > 1) {
        		int newA = a % 10;
        		newA *= multi;
        		a = newA;
        	}
        	System.out.println(a % 10 == 0 ? 10 : a % 10);
        }
    }
}