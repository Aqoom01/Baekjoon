import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String common = st.nextToken();
        
        List<StringBuilder> variables = new ArrayList<>();
        while(st.hasMoreTokens()) variables.add(new StringBuilder(st.nextToken()));
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < variables.size(); i++) {
            String temp = variables.get(i).deleteCharAt(variables.get(i).length() - 1).toString();
            StringBuilder type = new StringBuilder(common);
            
            int idx = -1;
            for(int j = temp.length() - 1; j >= 0; j--) {
                if(temp.charAt(j) == '*' || temp.charAt(j) == '&') type.append(temp.charAt(j));
            	else if(temp.charAt(j) == ']') {
                    type.append(temp.charAt(j - 1)).append(temp.charAt(j));
                    j--;
                }
                else {
                	idx = j;
                	break;
                }
            }
            temp = temp.substring(0, idx + 1);
            
            result.append(type.append(" ").append(temp).append(";").append("\n"));
        }
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}