import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Set<String> names = new HashSet<>();
		int answer = 0;
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			if(input.equals("ENTER")) names.clear();
			else if(names.add(input)) answer++;
		}
		
		bw.write("" + answer);		
        bw.flush();
        bw.close();
    }
}