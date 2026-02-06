import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new int[9];
        for(int i = 0; i < 9; i++) arr[i] = Integer.parseInt(br.readLine());
        
        visited = new boolean[9];
        result = new int[7];
        dfs(new int[7], 0, 0, 0);
        
        for(int i : result) System.out.println(arr[i]);
    }
    
    private static void dfs(int[] temp, int depth, int sum, int cursor) {
        if(depth == 7) {
            if(sum == 100) result = Arrays.copyOf(temp, 7);
            return;
        }
        for(int i = cursor; i < 9; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            temp[depth] = i;
            dfs(temp, depth + 1, sum + arr[i], i + 1);
            visited[i] = false;
        }
    }
}