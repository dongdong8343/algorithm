import java.util.*;
import java.io.*;
public class BaekjoonRe17143_3 {
    static int n, m, k, ret = 0;
    static class Shark{
        int r, c, s, d, z, death;
        Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int[][] a = new int[104][104];
    static Shark[] shark = new Shark[10004];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            a[r][c] = i;
            shark[i] = new Shark(r, c, s, d, z);
            if(d <= 1) shark[i].s %= 2 * (n - 1);
            else shark[i].s %= 2 * (m - 1);
        }
        for(int t = 0; t < m; t++){
            for(int i = 0; i < n; i++){
                if(a[i][t] != 0){
                    ret += shark[a[i][t]].z;
                    shark[a[i][t]].death = 1;
                    a[i][t] = 0;
                    break;
                }
            }
            int[][] temp = new int[104][104];
            for(int i = 1; i <= k; i++){
                if(shark[i].death == 1) continue;
                int y = shark[i].r;
                int x = shark[i].c;
                int s = shark[i].s;
                int d = shark[i].d;
                int ny, nx;
                while(true){
                    ny = y + s * dy[d];
                    nx = x + s * dx[d];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m) break;
                    if(d <= 1){
                        if(ny < 0){
                            s -= y;
                            y = 0;
                        }else{
                            s -= n - y - 1;
                            y = n - 1;
                        }
                    }else{
                        if(nx < 0){
                            s -= x;
                            x = 0;
                        }else{
                            s -= m - x - 1;
                            x = m - 1;
                        }
                    }
                    d ^= 1;
                }
                if(temp[ny][nx] != 0){
                    if(shark[temp[ny][nx]].z < shark[i].z){
                        shark[temp[ny][nx]].death = 1;
                        temp[ny][nx] = i;
                    }else shark[i].death = 1;
                }else temp[ny][nx] = i;
                shark[i].r = ny;
                shark[i].c = nx;
                shark[i].d = d;
            }
            a = temp;
        }
        System.out.println(ret);
    }
}