import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        String s = input[0];
        int rep = Integer.parseInt(input[1]);
        
        for(int i = 0; i < rep; i++) sb.append(s);
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}