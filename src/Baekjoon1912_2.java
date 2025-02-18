import java.io.*;
import java.util.*;

public class Baekjoon1912_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int ret = -987654321, now = 0;

        for (int i = 0; i < n; i++) {
            now += a[i];
            ret = Math.max(ret, now);
            if (now < 0) {
                now = 0;
            }
        }

        System.out.println(ret);
    }
}