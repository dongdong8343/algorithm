import java.util.*;
import java.io.*;
public class Baekjoon2468 {
    static int[][] map = new int[104][104];
    static int[][] visited = new int[104][104];
    static int height, min = 100, max = 2, n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx] == 1)
                continue;
            if(map[ny][nx] > height)
                dfs(ny, nx);
        }
        return;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int areaMax = 1;
        for(height = min; height < max; height++){
            int cnt = 0;
            visited = new int[104][104];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > height && visited[i][j] == 0){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            areaMax = Math.max(areaMax, cnt);
        }
        System.out.println(areaMax);
    }
}
