import java.io.*;
import java.util.*;

public class Baekjoon2667 {
    static List<Integer> li = new ArrayList<>();
    static int cnt = 0, n;
    static int[][] a = new int[30][30];
    static boolean[][] v = new boolean[30][30];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j] && a[i][j] == 1) {
                    cnt++;
                    int temp = dfs(i, j);
                    li.add(temp);
                }
            }
        }

        Collections.sort(li);
        System.out.println(cnt);
        for (int x : li) System.out.println(x);
    }

    static int dfs(int y, int x) {
        int num = 1;

        v[y][x] = true;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || v[ny][nx] || a[ny][nx] == 0) continue;
            num += dfs(ny, nx);
        }

        return num;
    }
}