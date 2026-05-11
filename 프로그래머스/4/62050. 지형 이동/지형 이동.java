import java.io.*;
import java.util.*;

public class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] land, int height) {
        int N = land.length;
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Ladder> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        visited[0][0] = true;
        q.add(new int[] {0, 0});

        int answer = 0;
        int count = 1;

        while (count < N * N) {

            // bfs로 사다리 없이 갈 수 있는 부분 전부 탐색
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny]) continue;

                    int diff = Math.abs(land[cur[0]][cur[1]] - land[nx][ny]);

                    if (diff <= height) {
                        visited[nx][ny] = true;
                        count++;
                        q.add(new int[] {nx, ny});
                    } else {
                        pq.add(new Ladder(nx, ny, diff));
                    }
                }
            }

            if (count == N * N) break;

            // 가장 낮은 사다리 선택
            while (!pq.isEmpty()) {
                Ladder ladder = pq.poll();

                if (visited[ladder.x][ladder.y]) continue;

                answer += ladder.cost;
                visited[ladder.x][ladder.y] = true;
                count++;
                q.add(new int[] {ladder.x, ladder.y});
                break;
            }
        }

        return answer;
    }
}

class Ladder {
    int x;
    int y;
    int cost;

    Ladder(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}