import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer> pays = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        long max = 0;
        long sum = 0;
        while(st.hasMoreTokens()) {
            int update = Integer.parseInt(st.nextToken());
            pays.add(update);
            sum += update;
            if(pays.size() > M) {
                int out = pays.remove(0);
                sum -= out;
            }
            max = Math.max(max, sum);
        }
        
        bw.write("" + max);
        bw.flush();
        bw.close();
	}
}