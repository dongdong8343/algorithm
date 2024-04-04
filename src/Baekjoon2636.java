import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Baekjoon2636 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt = 0, n, m;
    static int[][] visited;
    static int[][] map;
    static void go(int y, int x){
        visited[y][x] = 1;
        if(map[y][x] == 1){
            map[y][x] = 0;
            cnt++;
            return;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] == 1)
                continue;
            go(ny, nx);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Point> li = new ArrayList<>();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
            }
        }

        int time = 0;

        while(true){
            visited = new int[n][m];
            time++;
            cnt = 0;
            go(0, 0);
            int flag = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] != 0)
                        flag = 1;
                }
            }
            if(flag == 0) break;
        }

        System.out.println(time);
        System.out.println(cnt);


    }
}
