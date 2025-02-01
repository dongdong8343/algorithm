import java.io.*;
import java.util.*;
import java.awt.Point;

public class Baekjoon2580 {
    static int cnt = 0;
    static int[][] a = new int[14][14];
    static List<Point> li = new ArrayList<>();

    static void go(int idx) {
        if (idx == cnt) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        for (int i = 1; i <= 9; i++) {
            int x = li.get(idx).x;
            int y = li.get(idx).y;

            if (check(x, y, i)) {
                a[y][x] = i;
                go(idx + 1);
                a[y][x] = 0;
            }
        }
    }

    static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (a[y][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (a[i][x] == num) return false;
        }

        int sx = x / 3 * 3, sy = y / 3 * 3;
        for (int i = sy; i < sy + 3; i++) {
            for (int j = sx; j < sx + 3; j++) {
                if (a[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                a[i][j] = Integer.parseInt(s[j]);
                if (a[i][j] == 0) {
                    li.add(new Point(j, i));
                    cnt++;
                }
            }
        }

        go(0);
    }
}