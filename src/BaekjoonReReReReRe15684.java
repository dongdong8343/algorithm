import java.util.*;
import java.io.*;
public class BaekjoonReReReReRe15684 {
    static int [][] map;
    static int n, h, m, ret = 987654321;
    static int check(){
        for(int i = 1; i <= n; i++){
            int s = i;
            for(int j = 1; j <= h; j++){
                if(map[j][s] == 1) s++;
                else if(map[j][s - 1] == 1) s--;
            }
            if(s != i) return 0;
        }
        return 1;
    }
    static void go(int cnt, int here){
        if(cnt > 3 || ret <= cnt) return;
        if(check() == 1) {
            ret = Math.min(cnt, ret);
            return;
        }
        for(int i = here; i <= h; i++){
            for(int j = 1; j < n; j++){
                if(map[i][j] == 1 || map[i][j - 1] == 1 || map[i][j + 1] == 1) continue;
                map[i][j] = 1;
                go(cnt + 1, i);
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
        go(0, 1);
        if(ret != 987654321) System.out.println(ret);
        else System.out.println(-1);
    }
}