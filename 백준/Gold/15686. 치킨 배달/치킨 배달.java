import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Pair> house = new ArrayList<>();
		List<Pair> chickens = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				String token = st.nextToken();
				if(token.equals("1")) house.add(new Pair(i, j));
				else if(token.equals("2")) chickens.add(new Pair(i, j));
			}
		}
		
		// 조합을 통해 경우의 수 다 세기
		List<Integer[]> cases = new ArrayList<>();
		combi(cases, chickens.size(), M);
		
		// 각 조합에 따른 최소 거리 계산
		int min = Integer.MAX_VALUE;
		for(Integer[] arr : cases) {
			int[] distance = new int[house.size()];
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < house.size(); j++) {
					int temp = Math.abs(chickens.get(arr[i]).x - house.get(j).x) + Math.abs(chickens.get(arr[i]).y - house.get(j).y);
					if(distance[j] == 0) distance[j] = temp;
					else if(distance[j] > temp) distance[j] = temp;
				}
			}
			
			int sum = 0;
			for(int d : distance) sum += d;
			if(sum < min) min = sum;
		}
		
		bw.write("" + min);
		bw.flush();
		bw.close();
	}
	
	private static void combi(List<Integer[]> cases, int N, int R) {
		Integer[] selected = new Integer[R];
		
		combiRecursion(cases, selected, N, R, 0, 0);
	}
	
	private static void combiRecursion(List<Integer[]> cases, Integer[] selected, int N, int R, int depth, int start) {
		if(depth == R) {
			cases.add(selected.clone()); 
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[depth] = i;
			combiRecursion(cases, selected, N, R, depth + 1, i + 1);
		}
	}
	
}

class Pair {
	int x;
	int y;
	
	Pair() {}
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}