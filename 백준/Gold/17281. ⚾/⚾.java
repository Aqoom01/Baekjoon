import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	static boolean[] visited;
	static int[] output;
	static int[][] pas;
	static int N;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        answer = Integer.MIN_VALUE;
        visited = new boolean[10];
        output = new int[10];
        
        pas = new int[N][10];
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= 9; j++) {
        		pas[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
		visited[1] = true;
        countAllLineUps(1);
        System.out.println(answer);
    }
	
	// 모든 순열 세기
	static void countAllLineUps(int depth) {
		if(depth == 10) {			
			int score = calcScore();
			// System.out.println(output.toString() + ": " + score);
			return;
		}
		
		if(depth == 4) {
			output[depth] = 1;
			countAllLineUps(depth + 1);
			output[depth] = 0;
		}
		else {
			for(int i = 2; i <= 9; i++) {
				if(visited[i]) continue;
				
				visited[i] = true;
				output[depth] = i;
				countAllLineUps(depth + 1);
				output[depth] = 0;
				visited[i] = false;
			}
		}
	}
	
	// 해당 타순인 경우, 점수 계산
	static int calcScore() {
		int start = 1;
		int score = 0;
		Queue<Integer> runners = new ArrayDeque<>(); 

		for(int i = 0; i < N; i++) {
			// 이닝 시작 전 초기화
			int out = 0;

			runners.clear();
			runners.add(0);
			runners.add(0);
			runners.add(0);

			// 이닝 진행
			while(out < 3) {
				int pa = pas[i][output[start]];
				
				switch(pa) {
				case 0:
					out++;
					break;
				case 1:
				case 2:
				case 3:
				case 4:
					for(int h = 1; h <= pa; h++) {
						score += runners.poll();
						runners.add(h == 1? 1 : 0);
					}
					
					break;
				}
				
				start = start % 9 + 1;
			}
		}
		
		answer = Math.max(answer, score);
		return score;
	}
}