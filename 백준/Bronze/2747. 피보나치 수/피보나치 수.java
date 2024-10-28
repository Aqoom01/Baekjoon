import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>();
        arr.add(0);
        arr.add(1);
        arr.add(1);

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        for(int i = 3; i <= target; i++) {
            arr.add(arr.get(i - 1) + arr.get(i - 2));
        }
        System.out.println(arr.get(target));
    }
}