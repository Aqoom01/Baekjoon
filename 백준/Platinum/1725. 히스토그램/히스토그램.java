import java.io.*;
import java.util.*;

public class Main {
	static Deque<Node> s;
	static long answer;
    static int index;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	answer = 0;
        index = 0;
    	s = new ArrayDeque<>();
    	while(N-- > 0) {
    		int height = Integer.parseInt(br.readLine());
    		add(height);
    	}
    	add(0);
    	
    	System.out.println(answer);
	}
    
    private static void add(int height) {
        int start = index;

        while (!s.isEmpty() && s.peekLast().height > height) {
            Node prev = s.removeLast();
            answer = Math.max(answer, prev.height * (index - prev.idx));
            start = prev.idx;
        }

        if (s.isEmpty() || s.peekLast().height < height) {
            s.addLast(new Node(start, height));
        }

        index++;
    }
}

class Node {
	int idx;
	long height;
	
	Node(int idx, int height) {
		this.idx = idx; this.height = height;
	}
}