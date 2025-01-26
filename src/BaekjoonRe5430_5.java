import java.io.*;
import java.util.*;

public class BaekjoonRe5430_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            Deque<String> q = new LinkedList<>();
            boolean r = false, error = false;

            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String a = br.readLine();
            a = a.substring(1, a.length() - 1);
            if (!a.isEmpty()) {
                String[] num = a.split(",");
                for (int i = 0; i < n; i++) {
                    q.add(num[i]);
                }
            }

            for (char c : s.toCharArray()) {
                if (c == 'R') r = !r;
                else {
                    if (q.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (r) q.pollLast();
                    else q.pollFirst();
                }
            }

            if (error) System.out.println("error");
            else {
                StringBuilder sb = new StringBuilder("[");
                while(!q.isEmpty()){
                    sb.append(r ? q.pollLast() : q.pollFirst());
                    if(!q.isEmpty()) sb.append(',');
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}