import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '<') {
                    if (iter.hasPrevious()) iter.previous();
                } else if (ch == '>') {
                    if (iter.hasNext()) iter.next();
                } else if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(ch);
                }
            }

            for (char c : list) sb.append(c);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
