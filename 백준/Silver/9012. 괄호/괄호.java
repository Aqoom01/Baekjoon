import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String input = br.readLine();
			Stack<Character> st = new Stack<>();
		
			for(char c : input.toCharArray()) {
				if(c == '(') st.push(c);
				else {
					if(st.isEmpty()) st.push(c);
					else if(st.peek() == '(') st.pop();
					else st.push(c);
				}
			}
			
			System.out.println(st.isEmpty() ? "YES" : "NO");
		}
	}
}
