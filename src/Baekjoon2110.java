import java.io.*;
import java.util.*;

public class Baekjoon2110 {
    static List<Integer> li = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) li.add(Integer.parseInt(br.readLine()));
        Collections.sort(li);

        int l = 1;
        int r = li.get(n - 1) - li.get(0) + 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                l = mid + 1;
            }
            else r = mid - 1;
        }

        System.out.println(l - 1);
    }

    static boolean check(int mid) {
        int cnt = 1;
        int last = li.get(0);

        for (int i = 1; i < li.size(); i++) {
            if(li.get(i) - last >= mid) {
                cnt++;
                last = li.get(i);
            }
        }

        return cnt >= m;
    }
}