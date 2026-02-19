import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    static int N;
    static int[] oper = new int[4];
    static int[] output;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        output = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) oper[i] = Integer.parseInt(st.nextToken());
    
        dfs(0);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void dfs(int depth) {
        if(depth == N - 1) {
            int temp = nums[0];
            for(int i = 0; i < N - 1; i++) {
                switch(output[i]) {
                    case 0:
                        temp += nums[i + 1];
                        break;
                    case 1:
                        temp -= nums[i + 1];
                        break;
                    case 2:
                        temp *= nums[i + 1];
                        break;
                    case 3:
                        temp /= nums[i + 1];
                        break;
                }
            }
            
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        for(int i = 0; i < 4; i++) {
            if(oper[i] == 0) continue;
            
            output[depth] = i;
            oper[i] -= 1;
            dfs(depth + 1);
            oper[i] += 1;
        }
    }
}