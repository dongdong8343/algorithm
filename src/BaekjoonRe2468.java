import java.io.*;
import java.util.*;
public class BaekjoonRe2468 {
    static int[][] map = new int[104][104];
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static void go(int y, int x, int height){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1 || map[ny][nx] <= height)
                continue;
            go(ny, nx, height);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = 0, min = 104;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int ma = 1;

        for(int height = min; height < max; height++){
            int ret = 0;
            visited = new int[104][104];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > height && visited[i][j] == 0){
                        ret++;
                        go(i, j, height);
                    }
                }
            }
            ma = Math.max(ma, ret);
        }

        System.out.println(ma);
    }
}
