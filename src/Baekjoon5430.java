import java.util.*;
import java.io.*;

public class Baekjoon5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int s = 0; s < tc; s++) {
            String func = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String sa = br.readLine();

            sa = sa.substring(1, sa.length() - 1);
            Deque<Integer> deque = new ArrayDeque<>();
            if (!sa.isEmpty()) {
                String[] elements = sa.split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean isError = false;
            boolean rev = false;
            for (int i = 0; i < func.length(); i++) {
                char c = func.charAt(i);
                if (c == 'R') {
                    rev = !rev;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (rev) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (rev) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
