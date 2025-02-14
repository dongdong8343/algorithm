import java.io.*;
import java.util.*;

public class Baekjoon2636_2 {
    static int time = 0, cnt = 0, n, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] a = new int[104][104];
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        outer1:
        while (true) {
            time++;
            cnt = 0;
            v = new boolean[104][104];
            dfs(0, 0);

            outer2:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1) {
                        break outer2;
                    }
                }
                if (i == n - 1) break outer1;
            }
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    static void dfs(int y, int x) {
        v[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx]) continue;
            if (a[ny][nx] == 1) {
                v[ny][nx] = true;
                a[ny][nx] = 0;
                cnt++;
            } else dfs(ny, nx);
        }
        return;
    }
}