import java.util.*;
import java.io.*;
public class Baekjoon11658 {
    static int n, m;
    static long[][] tree = new long[1028][1028];
    static long[][] a = new long[1028][1028];
    static void update(int y, int x, long val){
        while(x <= n){
            tree[y][x] += val;
            x += (x & -x);
        }
    }
    static long sum(int y1, int x1, int y2, int x2){
        long ret = 0;
        for(int i = y1; i <= y2; i++){
            ret += _sum(i, x1, x2);
        }
        return ret;
    }
    static long _sum(int y, int x1, int x2){
        return go(y, x2) - go(y, x1 - 1);
    }
    static long go(int y, int x){
        long ret = 0;
        while(x > 0){
            ret += tree[y][x];
            x -= (x & -x);
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                a[i][j] = Long.parseLong(st.nextToken());
                update(i, j, a[i][j]);
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            if(w == 0) {
                int c = Integer.parseInt(st.nextToken());
                update(x1, y1, -a[x1][y1]);
                update(x1, y1, c);
                a[x1][y1] = c;
            }else{
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                long t = sum(x1, y1, x2, y2);
                sb.append(t).append("\n");
            }
        }
        System.out.println(sb);
    }
}