import java.io.*;
import java.util.*;

public class Baekjoon2852 {
    static int prev;

    static int go(int sum, int time) {
        sum += time - prev;
        return sum;
    }

    static void print(int sum) {
        int hour = sum / 60;
        int min = sum % 60;
        String sh = String.valueOf(hour);
        sh = "00" + sh;
        sh = sh.substring(sh.length() - 2);
        String sm = String.valueOf(min);
        sm = "00" + sm;
        sm = sm.substring(sm.length() - 2);
        System.out.println(sh + ":" + sm);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0, asum = 0, bsum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int idx = s.indexOf(':');
            int h = Integer.parseInt(s.substring(0, idx));
            int m = Integer.parseInt(s.substring(idx + 1));
            int time = h * 60 + m;
            if (a > b)
                asum = go(asum, time);
            else if (b > a)
                bsum = go(bsum, time);
            if (team == 1)
                a++;
            else
                b++;
            prev = time;
        }
        if (a > b)
            asum = go(asum, 48 * 60);
        else if (b > a)
            bsum = go(bsum, 48 * 60);
        print(asum);
        print(bsum);
    }
}