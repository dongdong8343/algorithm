import java.io.*;
import java.util.*;

public class Baekjoon2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void partition(int r, int c, int size) {
        if (check(r, c, size)) {
            if (board[r][c] == 0) white++;
            else blue++;
            return;
        }

        int ns = size / 2;
        partition(r, c, ns);
        partition(r, c + ns, ns);
        partition(r + ns, c, ns);
        partition(r + ns, c + ns, ns);
    }

    static boolean check(int r, int c, int size) {
        int color = board[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != color) return false;
            }
        }

        return true;
    }
}