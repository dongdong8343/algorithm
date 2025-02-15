import java.io.*;
import java.util.*;

public class Baekjoon2583_2 {
    static StringBuilder sb = new StringBuilder();
    static int[][] a = new int[104][104];
    static boolean[][] v = new boolean[104][104];
    static List<Integer> li = new ArrayList<>();
    static int n, m, k, ret = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    a[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && a[i][j] == 0) {
                    ret++;
                    li.add(dfs(i, j));
                }
            }
        }

        Collections.sort(li);

        sb.append(ret + "\n");
        for (int x : li) sb.append(x + " ");

        System.out.println(sb.toString());
    }

    static int dfs(int y, int x) {
        v[y][x] = true;
        int cnt = 1;

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] || a[ny][nx] != 0) continue;

            cnt += dfs(ny, nx);
        }

        return cnt;
    }
}