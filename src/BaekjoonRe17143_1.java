import java.io.*;
import java.util.*;
public class BaekjoonRe17143_1 {
    static class Shark{
        int x, y, s, d, z, death;
        Shark(int x, int y, int s, int d, int z){
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int n, m, k, ret = 0;
    static Shark[] a = new Shark[10004];
    static int[][] shark = new int[104][104];
    static int[][] temp = new int[104][104];
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
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            a[i] = new Shark(x, y, s, d, z);
            if(d <= 1) a[i].s %= 2 * (n - 1);
            else a[i].s %= 2 * (m - 1);
            shark[y][x] = i;
        }

        for(int t = 0; t < m; t++){
            for(int j = 0; j < n; j++){
                if(shark[j][t] != 0){
                    ret += a[shark[j][t]].z;
                    a[shark[j][t]].death = 1;
                    shark[j][t] = 0;
                    break;
                }
            }

            for(int row[] : temp) Arrays.fill(row, 0);

            for(int j = 1; j <= k; j++){
                if(a[j].death == 1) continue;
                int y = a[j].y;
                int x = a[j].x;
                int s = a[j].s;
                int d = a[j].d;
                int ny, nx;

                while(true){
                    ny = y + s * dy[d];
                    nx = x + s * dx[d];
                    if(ny >= 0 && nx >= 0 && ny < n && nx < m) break;
                    if(d <= 1){
                        if(ny < 0){
                            s -= y;
                            y = 0;
                        }else{
                            s -= n - 1 - y;
                            y = n - 1;
                        }
                    }else{
                        if(nx < 0){
                            s -= x;
                            x = 0;
                        }else{
                            s -= m - 1 - x;
                            x = m - 1;
                        }
                    }
                    d ^= 1;
                }

                if(temp[ny][nx] != 0){
                    if(a[temp[ny][nx]].z > a[j].z) a[j].death = 1;
                    else {
                        a[temp[ny][nx]].death = 1;
                        temp[ny][nx] = j;
                    }
                }else temp[ny][nx] = j;
                a[j].y = ny; a[j].x = nx; a[j].d = d;
            }
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < m; j++){
                    shark[i][j] = temp[i][j];
                }
            }
        }
        System.out.println(ret);
    }
}