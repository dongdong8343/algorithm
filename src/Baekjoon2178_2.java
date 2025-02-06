import java.io.*;
import java.util.*;
import java.awt.Point;

public class Baekjoon2178_2 {
    static int n, m;
    static int[][] a = new int[104][104];
    static int[][] v = new int[104][104];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            for(int j = 1; j <= m; j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j - 1)));
            }
        }

        bfs();

        System.out.println(v[n][m]);
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        v[1][1] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 1 || nx < 1 || ny > n || nx > m || a[ny][nx] == 0 || v[ny][nx] != 0) continue;

                v[ny][nx] = v[y][x] + 1;
                if(ny == n && nx == m) return;
                q.add(new Point(nx, ny));
            }
        }
    }


}