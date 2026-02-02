import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        char[] dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;
        int count = 0;
        for(int i = 0; i < dna.length; i++) {
            switch(dna[i]) {
                case 'A':
                    a++;
                    break;
                case 'C':
                    c++;
                    break;
                case 'G':
                    g++;
                    break;
                case 'T':
                    t++;
                    break;
            }

            if(i == P - 1) if(a >= A && c >= C && g >= G && t >= T) count++;
            if(i >= P) {
                switch(dna[i - P]) {
                    case 'A':
                        a--;
                        break;
                    case 'C':
                        c--;
                        break;
                    case 'G':
                        g--;
                        break;
                    case 'T':
                        t--;
                        break;
                }
                if(a >= A && c >= C && g >= G && t >= T) count++;
            }          
        }
        
        bw.write("" + count);
        bw.flush();
        bw.close();
	}
}