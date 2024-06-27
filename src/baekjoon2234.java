import java.util.*;
import java.io.*;
public class baekjoon2234 {
    static int m, n, ret1 = 0, ret2 = 0, ret3 = 0, area = 0, tc = 0, tm = 0;
    static int[][] map, visited;
    static void go(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0){
                    tc++;
                    area = 0;
                    visited[i][j] = 1;
                    count(i, j);
                    tm = Math.max(area, tm);
                }
            }
        }
    }
    static void count(int y, int x){
        area++;
        for(int i = 0; i < 4; i++){
            int ny = y;
            int nx = x;
            if((map[y][x] & (1 << i)) == 0){
                if((1 << i) == 1) nx--;
                else if((1 << i) == 2) ny--;
                else if((1 << i) == 4) nx++;
                else ny++;
                if(ny < 0 || nx < 0 || ny >= m || nx >= n || visited[ny][nx] == 1) continue;
                visited[ny][nx] = 1;
                count(ny, nx);
            }
        }
    }
    static void delete(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    if((map[i][j] & (1 << k)) != 0){
                        visited = new int[m + 4][n + 4];
                        map[i][j] -= (1 << k);
                        go();
                        ret3 = Math.max(ret3, tm);
                        map[i][j] += (1 << k);
                    }
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m + 4][n + 4];
        visited = new int[m + 4][n + 4];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go();
        ret1 = tc;
        ret2 = tm;
        tm = 0;
        tc = 0;
        delete();
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
    }
}