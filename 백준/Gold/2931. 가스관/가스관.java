import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Character, Integer> types;
    static int[][] enters;
    static Block[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        init(N, M);

        Pos start = null;
        Pos end = null;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = new Block(input.charAt(j));

                if(map[i][j].type == 'M') start = new Pos(i, j);
                if(map[i][j].type == 'Z') end = new Pos(i, j);
            }
        }

	    Pos target = findEmpty(start);	    
	    char answer = getShape(target);
	    System.out.println((target.r + 1) + " " + (target.c + 1) + " " + answer);
	}
	
	private static void init(int N, int M) {
	    types = new HashMap<>();
	    types.put('.', 0);
	    types.put('M', 1);
	    types.put('Z', 1);
	    types.put('|', 2);
	    types.put('-', 3);
	    types.put('+', 4);        
	    types.put('1', 5);
	    types.put('2', 6);
	    types.put('3', 7);
	    types.put('4', 8);
	    
	    enters = new int[][] {
	            {-1, -1, -1, -1},
	            {0, 1, 2, 3},
	            {2, -1, 0, -1},
	            {-1, 3, -1, 1},
	            {2, 3, 0, 1},
	            {-1, 2, 1, -1},
	            {1, 0, -1, -1},
	            {3, -1, -1, 0},
	            {-1, -1, 3, 2}
	    };
	    
	    map = new Block[N][M];
	}
	
	private static Pos findEmpty(Pos cur) {
	    int enterDir = -1;
	
	    while (true) {
	        if (map[cur.r][cur.c].type == 'M' || map[cur.r][cur.c].type == 'Z') {
	            for (int dir = 0; dir < 4; dir++) {
	                int nr = cur.r + dr[dir];
	                int nc = cur.c + dc[dir];
	
	                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) continue;
	                if(map[nr][nc].type == 'Z' || map[nr][nc].type == 'M' || map[nr][nc].type == '.') continue;
	                int inDir = (dir + 2) % 4;
	                if (map[nr][nc].enter[inDir] == -1) continue;

	                cur = new Pos(nr, nc);
	                enterDir = inDir;
	                break;
	            }
	        } else {
	            int nextDir = map[cur.r][cur.c].enter[enterDir];
	            if (nextDir == -1) break;
	
	            int nr = cur.r + dr[nextDir];
	            int nc = cur.c + dc[nextDir];
	            if (map[nr][nc].type == '.') {
	                return new Pos(nr, nc);
	            }
	
	            cur = new Pos(nr, nc);
	            enterDir = (nextDir + 2) % 4;
	        }
	    }
	    
	    return null;
	}
	
	private static char getShape(Pos p) {
	    boolean[] need = new boolean[4];
	    
	    for(int dir = 0; dir < 4; dir++) {
	        int nr = p.r + dr[dir];
	        int nc = p.c + dc[dir];
	        
	        if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length) need[dir] = false;
	        else if(map[nr][nc].type == 'M' || map[nr][nc].type == 'Z') need[dir] = false;
	        else need[dir] = map[nr][nc].enter[(dir + 2) % 4] == -1 ? false : true;
	    }
	    
	    boolean up = need[0];
	    boolean right = need[1];
	    boolean down = need[2];
	    boolean left = need[3];
	    
	    if(up && right && down && left) return '+';
	    if(up && down && !right && !left) return '|';
	    if(!up && !down && right && left) return '-';
	    if(!up && right && down && !left) return '1';
	    if(up && right && !down && !left) return '2';
	    if(up && !right && !down && left) return '3';
	    if(!up && !right && down && left) return '4';
	    
	    return '?';
	}
	
	static class Block {
	    char type;
	    int[] enter;
	    
	    Block(char type) {
	        this.type = type;
	        enter = enters[types.get(type)];
	    }
	}
	
	static class Pos {
	    int r, c;
	    
	    Pos() {}
	    Pos(int r, int c) { this.r = r; this.c = c; }
	
	    @Override
	    public boolean equals(Object o) {
	        if(this == o) return true;
	        if(!(o instanceof Pos)) return false;
	        
	        Pos other = (Pos) o;
	        return this.r == other.r && this.c == other.c;
	    }
	    
	    @Override
	    public int hashCode() {
	        return 31 * r + c;
	    }
	}
}