import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static List<Pair> cores;

	static int maxCore;
	static int minLen;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		StringBuilder out = new StringBuilder();

		int T = readInt();
		for (int t = 1; t <= T; t++) {
			N = readInt();
			map = new int[N][N];
			cores = new ArrayList<>();

			for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
				map[i][j] = readInt();
				if (map[i][j] == 1) {
					if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						cores.add(new Pair(i, j));
					}
				}
			}

			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			
			out.append("#").append(t).append(" ").append(minLen).append("\n");
		}

		System.out.print(out);
	}

	static void dfs(int idx, int connected, int length) {
		if (connected + (cores.size() - idx) < maxCore)
			return;

		if (idx == cores.size()) {
			if (connected > maxCore) {
				maxCore = connected;
				minLen = length;
			} else if (connected == maxCore) {
				minLen = Math.min(minLen, length);
			}
			return;
		}

		Pair p = cores.get(idx);

		for (int d = 0; d < 4; d++) {
			if (!canConnect(p.x, p.y, d))
				continue;

			int len = draw(p.x, p.y, d, 2);
			dfs(idx + 1, connected + 1, length + len);
			draw(p.x, p.y, d, 0);
		}

		// 연결 안 하는 경우
		dfs(idx + 1, connected, length);
	}

	static boolean canConnect(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];

		while (0 <= nx && nx < N && 0 <= ny && ny < N) {
			if (map[nx][ny] != 0)
				return false;
			nx += dx[d];
			ny += dy[d];
		}
		return true;
	}

	static int draw(int x, int y, int d, int val) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		int len = 0;

		while (0 <= nx && nx < N && 0 <= ny && ny < N) {
			map[nx][ny] = val;
			nx += dx[d];
			ny += dy[d];
			len++;
		}
		return len;
	}

	static int readInt() throws Exception {
		int c;
		while ((c = System.in.read()) <= 32)
			;

		int n = c - '0';
		while ((c = System.in.read()) > 47) {
			n = n * 10 + (c - '0');
		}

		return n;
	}
}

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}