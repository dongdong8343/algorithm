import java.io.*;
import java.util.*;
public class Baekjoon1012 {
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n, m, k;
    static void go(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= m || ny >= n || map[ny][nx] == 0) continue;
            if(visited[ny][nx] == 0)
                go(ny, nx);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            map = new int[54][54];
            visited = new int[54][54];
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }
            int ret = 0;
            for(int j = 0; j < n; j++){
                for(int l = 0; l < m; l++){
                    if(visited[j][l] == 0 && map[j][l] == 1) {
                        go(j, l);
                        ret++;
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
