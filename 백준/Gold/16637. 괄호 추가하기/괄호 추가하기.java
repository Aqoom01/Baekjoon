import java.io.*;
import java.util.*;

public class Main {
    static boolean[] output;
    static int operCnt;
    static String operation;
	static int answer;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        operCnt = N / 2;
        
        char[] operators = new char[operCnt];
        output = new boolean[operCnt];
        operation = br.readLine();
        
        answer = Integer.MIN_VALUE;
        countAll(0);
        
        System.out.println(answer);
    }
	
	static void countAll(int depth) {
		if(depth == operCnt) {
			// 괄호 계산
			List<String> firstOp = new ArrayList<>();
			firstOp.add("" + operation.charAt(0));
			for(int i = 1; i < operation.length(); i += 2) {
				if(output[i / 2]) {
					int digit1 = Integer.parseInt(firstOp.remove(firstOp.size() - 1));
					int digit2 = Integer.parseInt("" + operation.charAt(i + 1));
					
					switch(operation.charAt(i)) {
					case '+':
						firstOp.add("" + (digit1 + digit2));
						break;
					case '-':
						firstOp.add("" + (digit1 - digit2));
						break;
					case '*':
						firstOp.add("" + (digit1 * digit2));
						break;
					}
				}
				else {
					firstOp.add("" + operation.charAt(i));
					firstOp.add("" + operation.charAt(i + 1));
				}
			}
			
			// 앞에서부터 순서대로 계산
			int current = Integer.parseInt(firstOp.get(0));
	        for(int i = 1; i < firstOp.size(); i += 2) {
	        	switch(firstOp.get(i)) {
	        	case "*":
	        		current *= Integer.parseInt(firstOp.get(i + 1));
	        		break;
	        	case "+":
	        		current += Integer.parseInt(firstOp.get(i + 1));
	        		break;
	        	case "-":
	        		current -= Integer.parseInt(firstOp.get(i + 1));
	        		break;
	        	}
	        }
			
	        answer = Math.max(answer, current);
	        return;
		}
		
		output[depth] = false;
        countAll(depth + 1);

        if (depth == 0 || !output[depth - 1]) {
            output[depth] = true;
            countAll(depth + 1);
        }
	}
}