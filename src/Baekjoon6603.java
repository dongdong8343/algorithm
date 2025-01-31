import java.io.*;
import java.util.*;

public class Baekjoon6603 {
    static int[] a;
    static List<Integer> li = new ArrayList<>();
    static int n;
    static void go(int s, int cnt) {
        if (cnt == 6) {
            StringBuilder sb = new StringBuilder();
            for (int x : li) sb.append(x + " ");
            System.out.println(sb.toString());
            return;
        }
        for(int i = s + 1; i < n; i++){
            li.add(a[i]);
            go(i, cnt + 1);
            li.remove(li.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            a = new int[n + 1];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            go(-1, 0);
            System.out.println();
        }
    }
}