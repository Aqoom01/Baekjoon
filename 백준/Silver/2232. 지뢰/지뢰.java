import java.io.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class Main {	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] mines = new int[N + 1];
        for(int i = 1; i <= N; i++) mines[i] = Integer.parseInt(br.readLine());
        
        List<Integer> result = new ArrayList<>();
        int temp = Integer.MIN_VALUE;
        boolean isRise = true;
        for(int i = 1; i < N; i++) {
        	if(mines[i] >= mines[i - 1] && mines[i] >= mines[i + 1]) result.add(i);
        }
        if(mines[N] >= mines[N - 1]) result.add(N);
        
        StringBuilder sb = new StringBuilder();
        for(int i : result) sb.append(i).append("\n");
        bw.write(sb.toString());
        bw.close();
    }
}