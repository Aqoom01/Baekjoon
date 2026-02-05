import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static List<Integer>[] gears;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
    	int T = Integer.parseInt(br.readLine());
    	for(int t = 1; t <= T; t++) {
    		int K = Integer.parseInt(br.readLine());
    		gears = new ArrayList[4];
    		for(int i = 0; i < 4; i++) {
    			gears[i] = new ArrayList<Integer>();
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < 8; j++) gears[i].add(Integer.parseInt(st.nextToken()));
    		}
    		
    		while(K-- > 0) {
        		visited = new boolean[4];
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			int gearNum = Integer.parseInt(st.nextToken()) - 1;
    			int dir = Integer.parseInt(st.nextToken());
    			
    			move(gearNum, dir);
    		}
    		
    		int sum = 0;
    		for(int i = 0; i < 4; i++) {
    			sum += (gears[i].get(0) == 1) ? Math.pow(2, i) : 0;
    		}
    		bw.write("#" + t + " " + sum + "\n");
    	}
    	
    	bw.flush();
        bw.close();
    }
    
    private static void move(int gearNum, int dir) {
    	visited[gearNum] = true;
    	if(gearNum >= 1 && !visited[gearNum - 1] && gears[gearNum].get(6) != gears[gearNum - 1].get(2)) move(gearNum - 1, dir * -1);
    	if(gearNum <= 2 && !visited[gearNum + 1] && gears[gearNum].get(2) != gears[gearNum + 1].get(6)) move(gearNum + 1, -1 * dir);
    	
    	if(dir == 1) {
    		int temp = gears[gearNum].remove(7);
        	gears[gearNum].add(0, temp);
    	}
    	else {
    		int temp = gears[gearNum].remove(0);
    		gears[gearNum].add(temp);
    	}
    	
    }
}