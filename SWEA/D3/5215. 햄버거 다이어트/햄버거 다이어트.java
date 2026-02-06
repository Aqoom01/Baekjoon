import java.io.*;
import java.util.*;

public class Solution {
	static int L;
	static int N;
	static Ing[] ingredients;
	static boolean[] visited;
	static List<Integer> temp;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder().append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
            max = Integer.MIN_VALUE;
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ingredients = new Ing[N];
            int fullKal = 0;
            int fullScore = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
                int score = Integer.parseInt(st.nextToken());
                int kal = Integer.parseInt(st.nextToken());
				ingredients[i] = new Ing(i, score, kal);
             	
                fullKal += kal;
                fullScore += score;
			}
            if(fullKal <= L) {
            	bw.write(sb.append(fullScore).toString() + "\n");
                continue;
            }
			
			temp = new ArrayList<>();
			visited = new boolean[N];
			compute(0, 0, 0);
			
			bw.write(sb.append(max).toString() + "\n");
		}
		bw.close();
	}
	
	private static void compute(int kal_sum, int score_sum, int cursor) {
		if(kal_sum > L) {
			int ans = score_sum - ingredients[temp.get(temp.size() - 1)].score;
			if(ans > max) max = ans;
			return;
		}
		if(score_sum > max) max = score_sum;
		
		for(int i = cursor; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			temp.add(i);
			compute(kal_sum + ingredients[i].kal, score_sum + ingredients[i].score, i + 1);
			temp.remove((Integer) i);
			visited[i] = false;
		}
	}
}

class Ing {
	int id;
	int score;
	int kal;
	
	Ing (int id, int score, int kal) {
		this.id = id;
		this.score = score;
		this.kal = kal;
	}
}