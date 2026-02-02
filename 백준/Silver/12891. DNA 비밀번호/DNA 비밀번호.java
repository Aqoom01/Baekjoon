import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] pw = br.readLine().toCharArray();

        int[] check = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) check[i] = Integer.parseInt(st.nextToken());

        int[] curNum = new int[4];
        int valid = 0;
        int result = 0;

        // 초기 윈도우
        for (int i = 0; i < p; i++) {
            int idx = charToIndex(pw[i]);
            curNum[idx]++;
        }
        for (int i = 0; i < 4; i++) if (curNum[i] >= check[i]) valid++;
        if (valid == 4) result++;

        // 슬라이딩 윈도우
        for (int j = p; j < s; j++) {
            int out = charToIndex(pw[j - p]);
            int in = charToIndex(pw[j]);

            // 나가는 문자 처리
            if (curNum[out] >= check[out] && curNum[out] - 1 < check[out]) valid--;
            curNum[out]--;

            // 들어오는 문자 처리
            curNum[in]++;
            if (curNum[in] >= check[in] && curNum[in] - 1 < check[in]) valid++;

            if (valid == 4) result++;
        }


        System.out.println(result);
    }

    //문자에 따른 인덱스 매핑
    static int charToIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }
}
