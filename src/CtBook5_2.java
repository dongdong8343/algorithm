import java.io.*;
import java.util.*;
import java.awt.Point;
public class CtBook5_2 {
    static int n, m;
    static int[][] a = new int[1004][1004];
    static int[][] v = new int[1004][1004];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static void bfs(int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        v[y][x] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && v[ny][nx] == 0 && a[ny][nx] == 1){
                    q.add(new Point(nx, ny));
                    v[ny][nx] = v[p.y][p.x] + 1;
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs(0, 0);

        System.out.println(v[n - 1][m - 1]);
    }
}