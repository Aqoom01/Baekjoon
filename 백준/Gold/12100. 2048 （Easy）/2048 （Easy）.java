import java.io.*;
import java.util.*;

public class Main {
	static int max, N;
	static Block[][] map;
	public static void main(String[] args) throws IOException {
		N = readInt();
		map = new Block[N][N];
		
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) map[i][j] = new Block(readInt());
		
		max = Integer.MIN_VALUE;
		int[] arr = new int[5];
		findAllCases(0, arr);
		
		System.out.println(max);
	}
	
	// 중복 순열 구하기
	private static void findAllCases(int index, int[] arr) {
		if(index == arr.length) {
			simul(arr);
			return;
		}
		
		// 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
		for(int d = 0; d < 4; d++) {
			arr[index] = d;
			findAllCases(index + 1, arr);
		}
	}
	
	// 시뮬레이션
	private static void simul(int[] arr) {
		Block[][] temp = new Block[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
		        temp[i][j] = new Block(map[i][j].value);
		}
		
		for(int cur = 0; cur < 5; cur++) {
			for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) temp[i][j].isJoined = false;
			
			switch(arr[cur]) {
			case 0:
				moveUp(temp);
				break;
			case 1:
				moveRight(temp);
				break;
			case 2:
				moveDown(temp);
				break;
			case 3:
				moveLeft(temp);
			}
		}
		
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) max = Math.max(temp[i][j].value, max);
	}
	
	private static void moveUp(Block[][] temp) {
		for(int h = N - 1; h >= 1; h--) {
			for(int i = 1; i <= h; i++) for(int j = 0; j < N; j++) {
				if(temp[i - 1][j].value == 0) {
					temp[i - 1][j] = temp[i][j];
					temp[i][j] = new Block();
				}
				else if(temp[i - 1][j].value == temp[i][j].value) {
					if(!temp[i - 1][j].isJoined && !temp[i][j].isJoined) {
						temp[i - 1][j].value *= 2;
						temp[i][j] = new Block();
						temp[i - 1][j].isJoined = true;
					}
				}
			}
		}
	}
	
	private static void moveRight(Block[][] temp) {
		for(int h = 0; h <= N - 2; h++) {
			for(int j = N - 2; j >= h; j--) for(int i = 0; i < N; i++) {
				if(temp[i][j + 1].value == 0) {
					temp[i][j + 1] = temp[i][j];
					temp[i][j] = new Block();
				}
				else if(temp[i][j + 1].value == temp[i][j].value) {
					if(!temp[i][j + 1].isJoined && !temp[i][j].isJoined) {
						temp[i][j + 1].value *= 2;
						temp[i][j] = new Block();
						temp[i][j + 1].isJoined = true;
					}
				}
			}
		}
	}
	
	private static void moveDown(Block[][] temp) {
		for(int h = 0; h <= N - 2; h++) {
			for(int i = N - 2; i >= h; i--) for(int j = 0; j < N; j++) {
				if(temp[i + 1][j].value == 0) {
					temp[i + 1][j] = temp[i][j];
					temp[i][j] = new Block();
				}
				else if(temp[i + 1][j].value == temp[i][j].value) {
					if(!temp[i + 1][j].isJoined && !temp[i][j].isJoined) {
						temp[i + 1][j].value *= 2;
						temp[i][j] = new Block();
						temp[i + 1][j].isJoined = true;
					}
				}
			}
		}
	}
	
	private static void moveLeft(Block[][] temp) {
		for(int h = N - 1; h >= 1; h--) {
			for(int j = 1; j <= h; j++) for(int i = 0; i < N; i++) {
				if(temp[i][j - 1].value == 0) {
					temp[i][j - 1] = temp[i][j];
					temp[i][j] = new Block();
				}
				else if(temp[i][j - 1].value == temp[i][j].value) {
					if(!temp[i][j - 1].isJoined && !temp[i][j].isJoined) {
						temp[i][j - 1].value *= 2;
						temp[i][j] = new Block();
						temp[i][j - 1].isJoined = true;
					}
				}
			}
		}
	}
	
	// 초고속 입력기
	private static int readInt() throws IOException {
		int c;
		
		while((c = System.in.read()) <= 32) ;
		
		int sign = 1;
		if(c == '-') {
			sign = -1;
			c = System.in.read();
		}
		
		int n = c - '0';
		while((c = System.in.read()) > 32) {
			n = n * 10 + (c - '0');
		}
		
		return n * sign;
	}
}

class Block {
	int value;
	boolean isJoined;
	
	Block() {}
	Block(int value) { this.value = value; }
}