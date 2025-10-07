import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        String[] numbers = str.split(" ");
        
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        bw.write("a = " + a + "\n");
        bw.write("b = " + b + "\n");
        bw.flush();
        bw.close();
    }
}