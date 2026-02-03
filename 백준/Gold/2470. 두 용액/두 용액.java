import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] acids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()) acids[index++] = Integer.parseInt(st.nextToken());
        Arrays.sort(acids);
        
        int sum = Integer.MAX_VALUE;
        int min_i = -1;
        int min_j = N;
        
        int i = 0;
        int j = N - 1;
        while(i < j) {
            int temp = acids[i] + acids[j];
            if(Math.abs(temp) < Math.abs(sum)) {
                sum = temp;
                min_i = acids[i];
                min_j = acids[j];
            }
            
            if(temp > 0) j--;
            else i++;
        }
        
        bw.write(min_i + " " + min_j + "\n");
        bw.flush();
        bw.close();
	}
}