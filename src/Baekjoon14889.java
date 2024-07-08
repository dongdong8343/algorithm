import java.util.*;
import java.io.*;
public class Baekjoon14889 {
    static int n, ret = 987654321;
    static int[][] map = new int[24][24];
    static void go(int cnt, int mask, int idx){
        if(cnt > n / 2 || idx > n) return;
        if(cnt == n / 2){
            int[] a = new int[n];
            int[] b = new int[n];
            int ai = 0, bi = 0, t = 0;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0) a[ai++] = t++;
                else b[bi++] = t++;
            }
            int asum = 0, bsum = 0;
            for(int i = 0; i < (n / 2) - 1; i++){
                for(int j = i + 1; j < n / 2; j++){
                    asum += (map[a[i]][a[j]] + map[a[j]][a[i]]);
                    bsum += (map[b[i]][b[j]] + map[b[j]][b[i]]);
                }
            }
            ret = Math.min(ret, Math.abs(asum - bsum));
            return;
        }
        go(cnt, mask, idx + 1);
        go(cnt + 1, mask | (1 << idx), idx + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0);
        System.out.println(ret);
    }
}