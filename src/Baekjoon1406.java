import java.io.*;
import java.util.*;

public class Baekjoon1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> li = new LinkedList<>();

        String s = br.readLine();
        for (char c : s.toCharArray()) li.add(c);
        int n = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = li.listIterator();
        while (iter.hasNext()) iter.next();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            if (c == 'L' && iter.hasPrevious()) {
                iter.previous();
            } else if (c == 'D' && iter.hasNext()) {
                iter.next();
            } else if (c == 'B' && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            } else if (c == 'P') {
                char temp = command.charAt(2);
                iter.add(temp);
            }
        }

        for(Character c : li) bw.write(c);

        bw.flush();
        bw.close();
    }
}
