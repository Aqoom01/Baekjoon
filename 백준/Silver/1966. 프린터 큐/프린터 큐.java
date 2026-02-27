import java.io.*;
import java.util.*;

public class Main {
	static int[] importanceCnt;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	importanceCnt = new int[11];
        	
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            Queue<Doc> list = new ArrayDeque<>();
            for(int i = 0; i < N; i++) {
            	int current = Integer.parseInt(st.nextToken());
            	importanceCnt[current]++;
            	
                if(i == M) list.offer(new Doc(current, true));
                else list.offer(new Doc(current, false));
            }
            
            int idx = 1;
            while(!list.isEmpty()) {
            	// 현재 제일 앞의 문서
            	Doc current = list.poll();
            	
            	// 인쇄가 가능한지 확인
            	boolean canPoll = true;
            	for(int i = current.importance + 1; i <= 9 && canPoll; i++) {
            		if(importanceCnt[i] > 0) canPoll = false;
            	}
            	
            	// 인쇄 가능 여부에 따른 행동
            	if(!canPoll) list.offer(current);
            	else {
            		// 해당 문서가 타겟인 경우
            		if(current.isTarget) {
                		System.out.println(idx);
                		break;
                	}
            		
            		idx++;
            		importanceCnt[current.importance]--;
            	}
            }
        }
    }
}

class Doc {
    int importance;
    boolean isTarget;
    
    Doc() { }
    
    Doc(int importance, boolean isTarget) {
        this.importance = importance;
        this.isTarget = isTarget;
    }
}