import java.util.*;
import java.io.*;
public class BaekjoonReReRe15684 {
    static int n, h, m, ret = 987654321;
    static int[][] map;
    static boolean check(){
        for(int i = 1; i <= m; i++){
            int s = i;
            for(int j = 1; j <= n; j++){
                if(map[j][s] == 1) s++;
                else if(map[j][s - 1] == 1) s--;
            }
            if(s != i) return false;
        }
        return true;
    }
    static void go(int here, int cnt){
        if(ret <= cnt || cnt > 3) return;
        if(check()){
            ret = Math.min(ret, cnt);
            return;
        }
        for(int i = here; i <= n; i++){
            for(int j = 1; j < m; j++){
                if(map[i][j] == 1 || map[i][j - 1] == 1 || map[i][j + 1] == 1) continue;
                map[i][j] = 1;
                go(i, cnt + 1);
                map[i][j] = 0;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 세로선의 개수
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 개수
        map = new int[n + 4][m + 4];

        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        go(1, 0);
        if(ret == 987654321) System.out.println(-1);
        else System.out.println(ret);
    }
}