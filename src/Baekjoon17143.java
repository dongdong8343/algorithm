import java.io.*;
import java.util.*;
public class Baekjoon17143 {
    static class Shark{
        int y, x, s, d, z, death;
        Shark(int y, int x, int s, int d, int z){
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static Shark[] a = new Shark[10004];
    static int[][] shark = new int[104][104];
    static int[][] temp = new int[104][104];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int n, m, k, ret = 0;
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
            a[i] = new Shark(y, x, s, d, z);

            if(d <= 1) a[i].s %= (2 * (n - 1));
            else a[i].s %= (2 * (m - 1));

            shark[y][x] = i;
        }

        for(int t = 0; t < m; t++){
            for(int y = 0; y < n; y++){
                if(shark[y][t] != 0){
                    a[shark[y][t]].death = 1;
                    ret += a[shark[y][t]].z;
                    shark[y][t] = 0;
                    break;
                }
            }

            for(int [] row : temp) Arrays.fill(row, 0);

            for(int i = 1; i <= k; i++){
                if(a[i].death != 0) continue;

                int y = a[i].y;
                int x = a[i].x;
                int s = a[i].s;
                int d = a[i].d;
                int ny, nx;

                while(true){
                    ny = y + s * dy[d];
                    nx = x + s * dx[d];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m) break;
                    if(d <= 1) {
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
                    if(a[i].z > a[temp[ny][nx]].z){
                        a[temp[ny][nx]].death = 1;
                        temp[ny][nx] = i;
                    }else a[i].death = 1;
                }else temp[ny][nx] = i;

                a[i].y = ny;
                a[i].x = nx;
                a[i].d = d;
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    shark[i][j] = temp[i][j];
                }
            }
        }
        System.out.println(ret);
    }
}
