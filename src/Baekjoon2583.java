import java.io.*;
import java.util.*;
public class Baekjoon2583 {
    static int n, m, k;
    static int[][] map = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int cnt;
    static void dfs(int y, int x){
        visited[y][x] = 1;
        cnt++;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= m || nx >= n || visited[ny][nx] == 1)
                continue;
            if(map[ny][nx] == 0)
                dfs(ny, nx);
        }
        return;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int lx, ly, rx, ry;
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            lx = Integer.parseInt(st.nextToken());
            ly = Integer.parseInt(st.nextToken());
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());
            for(int j = ly; j < ry; j++){
                for(int k = lx; k < rx; k++){
                    map[j][k] = 1;
                }
            }
        }

        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0 && visited[i][j] == 0){
                    cnt = 0;
                    dfs(i, j);
                    li.add(cnt);
                }
            }
        }
        Collections.sort(li);
        System.out.println(li.size());
        for(int i : li)
            System.out.print(i + " ");
    }
}
