class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    int[][] maze;
    int n, m;
    Wagon red = new Wagon();
    Wagon blue = new Wagon();

    boolean[][] redVisited;
    boolean[][] blueVisited;

    int answer = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) red.cur = new Pos(i, j);
                if (maze[i][j] == 2) blue.cur = new Pos(i, j);
                if (maze[i][j] == 3) red.end = new Pos(i, j);
                if (maze[i][j] == 4) blue.end = new Pos(i, j);
            }
        }

        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];

        redVisited[red.cur.r][red.cur.c] = true;
        blueVisited[blue.cur.r][blue.cur.c] = true;

        dfs(red.cur, blue.cur, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(Pos redCur, Pos blueCur, int count) {
        if (count >= answer) return;

        boolean redArrived = redCur.equals(red.end);
        boolean blueArrived = blueCur.equals(blue.end);

        if (redArrived && blueArrived) {
            answer = Math.min(answer, count);
            return;
        }

        for (int rDir = 0; rDir < 4; rDir++) {
            Pos nextRed = redCur;

            if (!redArrived) {
                int nr = redCur.r + dr[rDir];
                int nc = redCur.c + dc[rDir];

                if (!isValid(nr, nc)) continue;
                if (redVisited[nr][nc]) continue;

                nextRed = new Pos(nr, nc);
            }

            for (int bDir = 0; bDir < 4; bDir++) {
                Pos nextBlue = blueCur;
                if (!blueArrived) {
                    int nr = blueCur.r + dr[bDir];
                    int nc = blueCur.c + dc[bDir];

                    if (!isValid(nr, nc)) continue;
                    if (blueVisited[nr][nc]) continue;

                    nextBlue = new Pos(nr, nc);
                }
                
                if (nextRed.equals(nextBlue)) continue;
                if (nextRed.equals(blueCur) && nextBlue.equals(redCur)) continue;
                
                if (!redArrived) redVisited[nextRed.r][nextRed.c] = true;
                if (!blueArrived) blueVisited[nextBlue.r][nextBlue.c] = true;

                dfs(nextRed, nextBlue, count + 1);

                if (!redArrived) redVisited[nextRed.r][nextRed.c] = false;
                if (!blueArrived) blueVisited[nextBlue.r][nextBlue.c] = false;
            }
        }
    }

    boolean isValid(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m) return false;
        if (maze[r][c] == 5) return false;
        return true;
    }
}

class Wagon {
    Pos cur, end;
    boolean isArrived = false;
}

class Pos {
    int r, c;

    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pos)) return false;
        Pos p = (Pos) other;
        return this.r == p.r && this.c == p.c;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(r, c);
    }
}