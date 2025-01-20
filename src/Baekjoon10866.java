import java.util.*;
import java.io.*;

public class Baekjoon10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push_front")) {
                int a = Integer.parseInt(st.nextToken());
                q.addFirst(a);
            } else if (s.equals("push_back")) {
                int a = Integer.parseInt(st.nextToken());
                q.addLast(a);
            } else if (s.equals("pop_front")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.pollFirst());
            } else if (s.equals("pop_back")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.pollLast());
            } else if (s.equals("size")) System.out.println(q.size());
            else if (s.equals("empty")) {
                if (q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (s.equals("front")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            } else {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peekLast());
            }
        }
    }
}