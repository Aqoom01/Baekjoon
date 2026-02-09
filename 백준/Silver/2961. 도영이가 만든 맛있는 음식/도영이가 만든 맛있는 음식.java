import java.io.*;
import java.util.*;

class Main
{
	static int N;
	static Food[] candidates;
	static List<Food> foods;
	static int diff = Integer.MAX_VALUE;
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        candidates = new Food[N + 1];
        
        for(int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	candidates[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        foods = new ArrayList<>();
        com(1);
        
        bw.write("" + diff);
        bw.close();
    }
    
    private static void com(int cursor) {
    	int sours = 1;
    	int bits = 0;
    	for(Food f : foods) {
    		sours *= f.sour;
    		bits += f.bit;
    	}
    	if(!foods.isEmpty() && Math.abs(sours - bits) < diff) diff = Math.abs(sours - bits);
    	
    	for(int i = cursor; i <= N; i++) {
    		foods.add(candidates[i]);
    		com(i + 1);
    		foods.remove(candidates[i]);
    	}
    }
}

class Food {
	int sour, bit;
	
	Food(int sour, int bit) {
		this.sour = sour;
		this.bit = bit;
	}
}