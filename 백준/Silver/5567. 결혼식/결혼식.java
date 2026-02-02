import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] relation = new int[N + 1][N + 1];
        Set<Integer> guest = new HashSet<>();
        
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
        
        for(int i = 1; i < N + 1; i++) {
            if(relation[1][i] == 1) guest.add(i);
        }
        
        List<Integer> temp = new ArrayList<>();
        for(int i : guest) {
            for(int j = 0; j < N + 1; j++) {
                if(relation[i][j] == 1) temp.add(j);
            }
        }
        for(int i : temp) guest.add(i);
        
        if(guest.size() == 0) bw.write("0");
        else bw.write("" + (guest.size() - 1));
        bw.flush();
        bw.close();
	}
}