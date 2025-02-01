import java.io.*;
import java.util.*;

public class Baekjoon2661 {
    static int n;

    static void go(int cnt, String s) {
        if (cnt == n) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (check(s + i)) {
                go(cnt + 1, s + i);
            }
        }
    }

    static boolean check(String s) {
        int length = s.length() / 2;
        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        go(0, "");
    }
}