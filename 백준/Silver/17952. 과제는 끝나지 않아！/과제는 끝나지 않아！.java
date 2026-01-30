import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		Stack<Pair> st = new Stack<>();
		for(int i = 0; i < N; i++) {
			String inputStr = br.readLine();
			if(inputStr.equals("0")) {
				if(st.isEmpty()) continue;
				if(st.peek().minute == 1) {
					total += st.peek().score;
					st.pop();
				}
				else st.peek().minute--;
			}
			else {
				String[] inputs = inputStr.split(" ");
				if(Integer.parseInt(inputs[2]) == 1) total += Integer.parseInt(inputs[1]);
				else st.add(new Pair(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]) - 1));
			}
		}
		
		System.out.println(total);
	}
}

class Pair {
	public int score;
	public int minute;
	
	Pair() {}
	Pair(int x, int y) { this.score = x; this.minute = y; }
}