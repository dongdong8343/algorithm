import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon15684 {
    static int[][] map;
    static int n, m, num, ok = 0, min = 987654321;

    static boolean check(){
        for(int i = 1; i <= m; i++){
            int s = i;
            ok = 0;
            for(int j = 1; j <= n; j++){
                if(map[j][s] == 1) s++;
                else if(map[j][s - 1] == 1) s--;
                if(j == n && s == i) ok = 1;
            }
            if(ok == 0) return false;
        }
        return true;
    }
    static void go(int here, int cnt){
        if(cnt >= min || cnt > 3) return;
        if(check()) {
            min = Math.min(min, cnt);
            return;
        }
        for(int i = here; i <= n; i++){
            for(int j = 1; j < m; j++){
                if(map[i][j] == 1 || map[i][j + 1] == 1 || map[i][j - 1] == 1) continue;
                map[i][j] = 1;
                go(i, cnt + 1);
                map[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];

        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        go(1, 0);
        if(min != 987654321) System.out.println(min);
        else System.out.println(-1);
    }
}