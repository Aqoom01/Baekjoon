import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int t = 1; t <= T; t++) {
    		StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int day = Integer.parseInt(st.nextToken());
    		int month = Integer.parseInt(st.nextToken());
    		int triMonth = Integer.parseInt(st.nextToken());
    		int year = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		int[] plan = new int[13];
    		for(int i = 1; i <= 12; i++) plan[i] = Integer.parseInt(st.nextToken());
    		
    		int[] answer = new int[13];
    		Arrays.fill(answer, Integer.MAX_VALUE);
    		answer[0] = 0;
    		for (int i = 1; i <= 12; i++) {
                int monthCost = Math.min(plan[i] * day, month);
                
                answer[i] = Math.min(answer[i], answer[i - 1] + monthCost);

                // 3달권 시작 (연말이면 남은 달만 적용)
                int end = Math.min(i + 2, 12);
                answer[end] = Math.min(answer[end], answer[i - 1] + triMonth);
            }

            // 1년권 비교
    		answer[12] = Math.min(answer[12], year);

    		sb.append(answer[12]);
    		System.out.println(sb.toString());
    	}
    }
}