import java.io.*;

public class Main {
	static Space[] map;
	static int answer, dices[];
	
    public static void main(String[] args) throws Exception {
    	init();
    	
    	dices = new int[10];
    	for(int i = 0; i < 10; i++) dices[i] = readInt();
    	
    	countAll(0, new int[10]);
    	System.out.println(answer);
    }
    
    private static void init() {
    	answer = 0;
    	map = new Space[33];
    	for(int i = 0; i <= 20; i++) {
    		map[i] = new Space(i * 2, i + 1);
    	}
    	map[21] = new Space(0, 21);
    	
    	map[5].specialRoute = 22;
    	map[10].specialRoute = 25;
    	map[15].specialRoute = 27;
    	
    	for(int i = 22; i <= 24; i++) map[i] = new Space(13 + 3 * (i - 22), i + 1);
    	for(int i = 25; i <= 26; i++) map[i] = new Space(22 + 2 * (i - 25), i + 1);
    	for(int i = 27; i <= 29; i++) map[i] = new Space(27 - (i - 28), i + 1);
    	for(int i = 30; i <= 32; i++) map[i] = new Space(25 + 5 * (i - 30), i + 1);
    	
    	map[24].to = 30;
    	map[26].to = 30;
    	map[29].to = 30;
    	map[32].to = 20;    	
    }
    
    private static void countAll(int cursor, int[] output) {
    	if(cursor == output.length) {
    		sumScore(output);
    		return;
    	}
    	
    	for(int idx = 0; idx < 4; idx++) {
    		output[cursor] = idx;
    		countAll(cursor + 1, output);
    	}
    }
    
    private static void sumScore(int[] output) {
    	int[] positions = new int[4]; // 말 4개
        int score = 0;

        for (int turn = 0; turn < 10; turn++) {
            int piece = output[turn];
            int cur = positions[piece];
            
            if (cur == 21) return;
            
            int dist = dices[turn];
            if (map[cur].specialRoute != -1) cur = map[cur].specialRoute;
            else cur = map[cur].to;
            dist--;
            
            while (dist-- > 0) {
                cur = map[cur].to;
            }

            if (cur != 21) {
                for (int i = 0; i < 4; i++) {
                    if (i == piece) continue;
                    
                    if (positions[i] == cur) return;
                }
            }

            positions[piece] = cur;
            score += map[cur].score;
        }

        answer = Math.max(answer, score);
    }

    static int readInt() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32);

        int n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Space {
	int score, to, specialRoute;

	Space(int score, int to) {
		this.score = score;
		this.to = to;
		this.specialRoute = -1;
	}
}