import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] input = br.readLine().toCharArray();
		int answer = -1;
		int index = 0;
		while(answer == -1) {
			boolean find = true;
			for(int i = index, j = input.length - 1; i <= j; i++, j--) {
				if(input[i] != input[j]) {
					find = false;
					break;
				}
			}
			
			if(find) answer = input.length + index;
			index++;
		}
		if(answer == -1) answer = input.length * 2 - 1;
		
		bw.write("" + answer);
		bw.flush();
		bw.close();
	}
}