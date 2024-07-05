import java.util.*;
import java.io.*;
public class BaekjoonRe15684_6 {
    static int n, h, m, ret = 987654321;
    static int[][] map;
    static void go(int cnt, int idx){
        if(cnt >= ret || cnt > 3) return;
        if(check()) {
            ret = Math.min(ret, cnt);
            return;
        }
        for(int i = idx; i <= m; i++){
            for(int j = 1; j < n; j++){
                if(map[i][j] == 1 || map[i][j - 1] == 1 || map[i][j + 1] == 1) continue;
                map[i][j] = 1;
                go(cnt + 1, i);
                map[i][j] = 0;
            }
        }
    }
    static boolean check(){
        for(int i = 1; i <= n; i++){
            int s = i;
            for(int j = 1; j <= m; j++){
                if(map[j][s] == 1) s++;
                else if(map[j][s - 1] == 1) s--;
            }
            if(s != i) return false;
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m + 4][n + 4];
        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        go(0, 1);
        if(ret == 987654321) System.out.println(-1);
        else System.out.println(ret);
    }
}