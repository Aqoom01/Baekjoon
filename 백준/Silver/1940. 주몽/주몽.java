import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()) nums[idx++] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        
        int cnt = 0;
        for(int i = 0, j = N - 1; i < j; ) {
            int temp = nums[i] + nums[j];
            if(temp == M) {
                cnt++;
                i++;
                j--;
            }
            else if(temp > M) j--;
            else i++;
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
	}
}