import java.util.*;
import java.io.*;
public class fartDfs {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited = new int[100][100];
    static int[][] map = new int[100][100];
    static ArrayList<Integer>[] adj;
    static int n = 0;
    static int m = 0;
    static void go(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[ny][nx] == 0 && map[ny][nx] != 0)
                go(ny, nx);
        }
        return;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] != 1 && map[i][j] == 1){
                    cnt++;
                    go(i, j);
                }
            }
        }
        System.out.println(cnt);
    }
}
