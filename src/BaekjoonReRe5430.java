import java.util.*;
import java.io.*;

public class BaekjoonReRe5430 {
    static int tc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int s = 0; s < tc; s++) {
            String c = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr1 = br.readLine();
            arr1 = arr1.substring(1, arr1.length() - 1);
            String[] arr2 = arr1.split(",");
            Deque<Integer> dq = new LinkedList<>();
            for (int i = 0; i < n; i++) dq.add(Integer.parseInt(arr2[i]));
            boolean error = false, rev = false;
            for (int i = 0; i < c.length(); i++) {
                if (c.charAt(i) == 'R') rev = !rev;
                else {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (rev) dq.removeLast();
                    else dq.removeFirst();
                }
            }
            if (error) System.out.println("error");
            else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!dq.isEmpty()) {
                    if (rev) sb.append(dq.removeLast());
                    else sb.append(dq.removeFirst());
                    if (!dq.isEmpty()) sb.append(',');
                }
                sb.append(']');
                System.out.println(sb.toString());
            }
        }
    }
}