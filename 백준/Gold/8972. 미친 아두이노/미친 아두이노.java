import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Jong jong = new Jong();
		List<Aduino> aduList = new ArrayList<>();
		
		char[][] map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				
				if(input.charAt(j) == 'I') {
					jong.r = i;
					jong.c = j;
				}
				else if(input.charAt(j) == 'R') aduList.add(new Aduino(i, j));
			}
		}
		
		String input = br.readLine();
		for(int i = 0; i < input.length(); i++) {
			// 종수 움직임
			int move = input.charAt(i) - '0';
			map[jong.r][jong.c] = '.';

			// 종료 여부 확인
			if(map[jong.r + dr[move]][jong.c + dc[move]] == 'R') {
				System.out.println("kraj " + (i + 1));
				return;
			}
			else {
				jong.r += dr[move];
				jong.c += dc[move];
				
				map[jong.r][jong.c] = 'I'; 
			}
						
			// 아두이노 움직임
			Aduino[][] tempMap = new Aduino[R][C];
			for(Aduino a : aduList) {
				if(a.isDestroyed) continue;
				int index = -1;
				int dist = Integer.MAX_VALUE;
				
				for(int dir = 1; dir <= 9; dir++) {
					int nr = a.r + dr[dir];
					int nc = a.c + dc[dir];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					
					int temp = Math.abs(jong.r - nr) + Math.abs(jong.c - nc);
					if(temp < dist) {
						index = dir;
						dist = temp;
					}
				}
				
				int nr = a.r + dr[index];
				int nc = a.c + dc[index];
				if(tempMap[nr][nc] != null) {
					// 아두이노 파괴
					tempMap[nr][nc].isDestroyed = true;
					a.isDestroyed = true;
				}
				// 종료 여부 확인
				else if(map[nr][nc] == 'I') {
					System.out.println("kraj " + (i + 1));
					return;
				}
				else {
					tempMap[nr][nc] = a;
					a.nr = nr;
					a.nc = nc;
				}
			}
			
			List<Aduino> renewal = new ArrayList<>();
			for(Aduino a : aduList) {
				map[a.r][a.c] = '.'; 
			}
			for(Aduino a : aduList) {
			    if(!a.isDestroyed) {
			        a.r = a.nr;
			        a.c = a.nc;
			        map[a.r][a.c] = 'R';
			        renewal.add(a);
			    }
			}
			aduList = renewal;
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static class Jong {
		int r, c;
	}

	static class Aduino {
		int r, c;
		int nr, nc;
		boolean isDestroyed;
		
		Aduino(int r, int c) {
			this.r = r;
			this.c = c;
			this.isDestroyed = false;
		}
	}
}