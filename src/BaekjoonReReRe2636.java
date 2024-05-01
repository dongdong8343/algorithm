import java.util.*;
import java.io.*;
public class BaekjoonReReRe2636 {
    static int n, m, time, cnt, cheese = 0;
    static int[][] map = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void dfs(int y, int x){
        visited[y][x] = 1;
        if(map[y][x] == 1){
            cnt++;
            map[y][x] = 0;
            return;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx >= m || nx < 0)
                continue;
            else if(visited[ny][nx] == 0){
                dfs(ny, nx);
            }
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
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1)
                    cheese++;
            }
        }

        while(true){
            cnt = 0;
            visited = new int[104][104];
            time++;
            dfs(0, 0);
            cheese -= cnt;
            if(cheese == 0)
                break;
        }
        System.out.println(time);
        System.out.println(cnt);
    }
}
