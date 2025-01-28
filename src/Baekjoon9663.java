import java.io.*;
import java.util.*;

public class Baekjoon9663 {
    static int cnt = 0, n;
    static int[] a = new int[20];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(cnt);
    }

    static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            a[depth] = i;
            if (possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean possibility(int col){
        for(int i = 0; i < col; i++){
            if(a[col] == a[i]) return false;
            else if(Math.abs(col - i) == Math.abs(a[col] - a[i])) return false;
        }
        return true;
    }
}