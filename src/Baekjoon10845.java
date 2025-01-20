import java.util.*;
import java.io.*;

public class Baekjoon10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                q.add(a);
            } else if (s.equals("pop")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.poll());
            } else if (s.equals("size")) System.out.println(q.size());
            else if (s.equals("empty")) {
                if (q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (s.equals("front")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            } else{
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peekLast());
            }
        }
    }
}