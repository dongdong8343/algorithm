import java.util.*;
import java.io.*;
public class BaekjoonReRe15684 {
    static int n, m, h, min = 987654321;
    static int[][] map;
    static boolean check(){
        for(int i = 1; i <= n; i++){
            int s = i;
            for(int j = 1; j <= h; j++){
                if(map[j][s] == 1) s += 1;
                else if(map[j][s - 1] == 1) s -= 1;
            }
            if(s != i) return false;
        }
        return true;
    }
    static void go(int here, int cnt){
        if(cnt > 3 || cnt > min) return;
        if(check()) min = Math.min(min, cnt);
        for(int i = here; i <= h; i++){
            for(int j = 1; j < n; j++){
                if(map[i][j - 1] == 1 || map[i][j] == 1 || map[i][j + 1] == 1) continue;
                map[i][j] = 1;
                go(i, cnt + 1);
                map[i][j] = 0;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h + 1][n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        go(0, 0);
        if(min == 987654321) System.out.println(-1);
        else System.out.println(min);
    }
}