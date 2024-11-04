import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 조합 계산 함수 (팩토리얼 없이 직접 계산)
    public static long combination(int n, int r) {
        if (r == 0 || n == r) return 1; // nC0 = 1, nCn = 1

        long result = 1;
        // 더 작은 쪽을 r로 선택
        r = Math.min(r, n - r);

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력
        
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트 수
            int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트 수

            sb.append(combination(M, N)).append("\n");
            System.out.print(sb); // 결과 출력
        }
    }
}
