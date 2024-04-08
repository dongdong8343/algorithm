import java.util.*;
import java.io.*;
public class BaekjoonReRe2636 {
    static int[][] map = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, cnt;
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(map[ny][nx] == 1){
                cnt++;
                visited[ny][nx] = 1;
                map[ny][nx] = 0;
                continue;
            }
            if(visited[ny][nx] != 1 && map[ny][nx] == 0)
                dfs(ny, nx);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0, ret = 0;
        while(true){
            time++;
            cnt = 0;
            visited = new int[104][104];
            dfs(0,0);
            int flag = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1)
                        flag = 1;
                }
            }
            if(flag == 0)
                break;
        }
        System.out.println(time);
        System.out.println(cnt);
    }
}
