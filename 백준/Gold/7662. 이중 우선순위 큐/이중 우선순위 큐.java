import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	TreeMap<Integer, Integer> map = new TreeMap<>();
        	int k = Integer.parseInt(br.readLine());
        	
        	while(k-- > 0) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		String cmd = st.nextToken();
        		int num = Integer.parseInt(st.nextToken());
        		
        		switch(cmd) {
        		case "I":
        			map.put(num, map.getOrDefault(num, 0) + 1);
        			break;
        		case "D":
        			removeElement(map, num);
        		}
        	}
        	
        	System.out.println(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
    
    private static void removeElement(TreeMap<Integer, Integer> map, int option) {
    	if(map.isEmpty()) return;
    	
    	if(option == 1) {
    		int largest = map.lastKey();
    		int cnt = map.get(largest);
    		map.remove(largest);
    		
    		if(cnt > 1) {
    			map.put(largest, cnt - 1);
    		}
    	}
    	else {
    		int least = map.firstKey();
    		int cnt = map.get(least);
    		map.remove(least);
    		
    		if(cnt > 1) map.put(least, cnt - 1);
    	}
    }
}