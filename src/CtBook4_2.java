import java.io.*;
import java.util.*;
public class CtBook4_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] a = new int[54][54];
        int[][] visited = new int[54][54];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int nx = 0, ny = 0, cnt = 0, ret = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited[y][x] = 1; ret++;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(cnt == 4) {
                nx = x - dx[v];
                ny = y - dy[v];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx] == 1 || a[ny][nx] == 1) break;
                visited[ny][nx] = 1;
                x = nx;
                y = ny;
                ret++;
                cnt = 0;
            }

            v--;
            if(v == -1) v = 3;

            nx = x + dx[v];
            ny = y + dy[v];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx] == 1 || a[ny][nx] == 1) {
                cnt++;
            }else {
                cnt = 0;
                visited[ny][nx] = 1;
                x = nx;
                y = ny;
                ret++;
            }
        }

        System.out.println(ret);
    }
}