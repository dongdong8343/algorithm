import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Baekjoon1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int cnt = 0, idx = 0;
            List<Integer> li = new ArrayList<>();
            Queue<Point> q = new LinkedList<>();
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                li.add(Integer.parseInt(s[i]));
                q.add(new Point(i, Integer.parseInt(s[i])));
            }

            Collections.sort(li, Collections.reverseOrder());

            while (idx < li.size()) {
                Point temp = q.poll();
                if (li.get(idx) == temp.y) {
                    idx++;
                    cnt++;
                    if (temp.x == m) break;
                } else q.add(temp);
            }

            System.out.println(cnt);
        }
    }
}