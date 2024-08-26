import java.util.*;
import java.io.*;
public class BaekjoonRe17143_4 {
    static int n, m, c, ret = 0;
    static class Shark{
        int y, x, s, d, z, dead;
        Shark(int y, int x, int s, int d, int z){
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static Shark[] shark = new Shark[10004];
    static int[][] a = new int[104][104];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args)throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       c = Integer.parseInt(st.nextToken());
       for(int i = 1; i <= c; i++){
           st = new StringTokenizer(br.readLine());
           int y = Integer.parseInt(st.nextToken()) - 1;
           int x = Integer.parseInt(st.nextToken()) - 1;
           int s = Integer.parseInt(st.nextToken());
           int d = Integer.parseInt(st.nextToken()) - 1;
           int z = Integer.parseInt(st.nextToken());
           if(d <= 1) s %= 2 * (n - 1);
           else s %= 2 * (m - 1);
           shark[i] = new Shark(y, x, s, d, z);
           a[y][x] = i;
       }
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               if(a[j][i] != 0){
                   ret += shark[a[j][i]].z;
                   shark[a[j][i]].dead = 1;
                   a[j][i] = 0;
                   break;
               }
           }
           int[][] temp = new int[104][104];
           for(int j = 1; j <= c; j++){
               if(shark[j].dead == 1) {
                   continue;
               }
               int y = shark[j].y;
               int x = shark[j].x;
               int d = shark[j].d;
               int s = shark[j].s;
               int ny = y + dy[d] * s;
               int nx = x + dx[d] * s;
               while(ny >= n || nx >= m || ny < 0 || nx < 0){
                   d ^= 1;
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
                   ny = y + dy[d] * s;
                   nx = x + dx[d] * s;
               }
               shark[j].y = ny;
               shark[j].x = nx;
               shark[j].d = d;
               if(temp[ny][nx] != 0){
                   if(shark[temp[ny][nx]].z > shark[j].z){
                       shark[j].dead = 1;
                   }else{
                       shark[temp[ny][nx]].dead = 1;
                       temp[ny][nx] = j;
                   }
               }else temp[ny][nx] = j;
           }
           for(int s = 0; s < n; s++){
               for(int j = 0; j < m; j++){
                   a[s][j] = temp[s][j];
               }
           }
       }
       System.out.println(ret);
    }
}