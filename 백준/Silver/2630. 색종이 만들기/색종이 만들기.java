import java.io.*;
import java.util.*;

public class Main {	
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) { 
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        divideAndConquer(map, N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
	}
	
	static void divideAndConquer(int[][] map, int N, int i_start, int j_start) {
		int flag = -1;
		for(int i = i_start; i < i_start + N; i++) {
			for(int j = j_start; j < j_start + N; j++) {
				if(i == i_start && j == j_start) flag = map[i][j];
				else {
					if(map[i][j] != flag) {
						divideAndConquer(map, N / 2, i_start, j_start);
						divideAndConquer(map, N / 2, i_start + N / 2, j_start);
						divideAndConquer(map, N / 2, i_start, j_start + N / 2);
						divideAndConquer(map, N / 2, i_start + N / 2, j_start + N / 2);
						
						return;
					}
				}
			}
		}
		
		if(flag == 1) blue++;
		else white++;
	}
}