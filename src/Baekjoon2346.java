import java.util.*;
import java.io.*;
import java.awt.Point;

public class Baekjoon2346 {
    static int n;
    static Deque<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= n; i++) {
            q.addLast(new Point(i, Integer.parseInt(st.nextToken())));
        }

        Point t = q.pollFirst();
        bw.write(t.x + " ");
        while (!q.isEmpty()) {
            int steps = t.y;
            if (steps > 0) {
                // steps가 q.size()보다 큰 경우 실제로 모든 이동을 할 필요가 없습니다.
                steps = steps % q.size();
                if (steps == 0) steps = q.size();
                for (int i = 0; i < steps - 1; i++) {
                    q.addLast(q.pollFirst());
                }
                t = q.pollFirst();
            } else {
                // steps가 q.size()보다 큰 경우 실제로 모든 이동을 할 필요가 없습니다.
                steps = (-steps) % q.size();
                if (steps == 0) steps = q.size();
                for (int i = 0; i < steps - 1; i++) {
                    q.addFirst(q.pollLast());
                }
                t = q.pollLast();
            }
            bw.write(t.x + " ");
        }

        bw.flush();
        bw.close();
    }
}
