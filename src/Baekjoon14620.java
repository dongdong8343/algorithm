import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon14620 {
    static int n, min = 987654321;
    static int[][] map = new int[14][14];
    static int[][] visited = new int[14][14];
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
    static void go(int here, int cnt, int price){
        if(price > min) return;
        if(cnt == 3){
            min = Math.min(min, price);
            return;
        }
        for(int i = here; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(visited[i][j] == 1) continue;
                int sum = 0, ok = 0;
                List<Point> li = new ArrayList<>();
                for(int k = 0; k < 5; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(visited[ny][nx] == 1){
                        ok = 1;
                        break;
                    }
                    li.add(new Point(nx, ny));
                    visited[ny][nx] = 1;
                    sum += map[ny][nx];
                }
                if(ok == 1){
                    for(Point p : li)
                        visited[p.y][p.x] = 0;
                    continue;
                }
                go(i, cnt + 1, price + sum);
                for(Point p : li)
                    visited[p.y][p.x] = 0;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j = 0; j < n; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        go(1, 0, 0);
        System.out.println(min);
    }
}