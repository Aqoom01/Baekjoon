import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                for(int k = 1; k <= 9; k++) {
                    if(i != j && i != k && j != k) list.add(""+ i + j + k);
                }
            }
        }
        
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int strikes = Integer.parseInt(st.nextToken());
            int balls = Integer.parseInt(st.nextToken());
            
            List<String> removes = new ArrayList<>();
            for(String e : list) {
                char[] element = e.toCharArray();
                char[] inputArr = input.toCharArray();
                int tempStrikes = 0;
                int tempBalls = 0;
                
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        if(element[i] == inputArr[j]) {
                        	if(i == j) tempStrikes++;
                        	else tempBalls++;
                        }
                    }
                }
                
                if(tempStrikes != strikes || tempBalls != balls) removes.add(e);
            }
            for(String s : removes) list.remove(s);
        }
        
        bw.write("" + list.size());
        bw.flush();
        bw.close();
    }
}