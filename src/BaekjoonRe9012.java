import java.io.*;
import java.util.*;

public class BaekjoonRe9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            boolean error = false;

            for (char c : s.toCharArray()) {
                if (c == ')') {
                    if (!st.isEmpty()) st.pop();
                    else {
                        error = true;
                        break;
                    }
                } else st.push(c);
            }
                if (!st.isEmpty() || error) System.out.println("NO");
                else System.out.println("YES");
            }

        }
    }