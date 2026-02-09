import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] customer = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) customer[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(customer);
        
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += customer[i] * (N - i);
        }
        
        System.out.println(sum);
    }
}