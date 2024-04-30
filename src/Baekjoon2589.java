import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon2589 {
    static int n, m, max = 0;
    static Point s, e;
    static int[][] map = new int[54][54];
    static int[][] visited = new int[54][54];
    static List<Point> li = new ArrayList<>();
    static List<Point> com = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int by, int bx){
        visited = new int[54][54];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(bx, by));
        visited[by][bx] = 1;
        while(!q.isEmpty()){
            Point temp = q.poll();
            int y = temp.y;
            int x = temp.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0) continue;
                else if(map[ny][nx] == 1){
                    q.add(new Point(nx, ny));
                    visited[ny][nx] = visited[y][x] + 1;
                    max = Math.max(max, visited[ny][nx]);
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
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == 'L'){
                    li.add(new Point(j, i));
                    map[i][j] = 1;
                }
                else
                    map[i][j] = 0;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1) bfs(i, j);
            }
        }
        System.out.println(max - 1);
    }
}
