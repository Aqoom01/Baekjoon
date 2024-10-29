import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long current = S;

        for(int i = 1; i <= S; i++) {
            if(current < i) {
                break;
            }
            else if (current == i) {
                count += 1;
                break;
            }
            else {
                current = current - i;
                count++;
            }
        }

        System.out.println(count);
    }
}