import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe4179 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        int[][] jvisited = new int[r][c];
        int[][] fvisited = new int[r][c];
        Queue<Point> fj = new LinkedList<>();
        Queue<Point> ff = new LinkedList<>();
        List<Point> escape = new ArrayList<>();
        int min = 10000000;
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                fvisited[i][j] = 10000000;
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J'){
                    fj.add(new Point(j, i));
                    jvisited[i][j] = 1;
                }
                else if(map[i][j] == 'F'){
                    fvisited[i][j] = 1;
                    ff.add(new Point(j, i));
                }
            }
        }
        while(!fj.isEmpty()){
            Point p = fj.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c){
                    escape.add(new Point(p.x, p.y));
                    continue;
                }
                if(jvisited[ny][nx] == 0 && map[ny][nx] == '.'){
                    jvisited[ny][nx] = jvisited[p.y][p.x] + 1;
                    fj.add(new Point(nx, ny));
                }
            }
        }
        while(!ff.isEmpty()){
            Point p = ff.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(fvisited[ny][nx] == 10000000 && (map[ny][nx] == '.' || map[ny][nx] == 'J')){
                    fvisited[ny][nx] = fvisited[p.y][p.x] + 1;
                    ff.add(new Point(nx, ny));
                }
            }
        }

        for(Point p : escape){
            if(jvisited[p.y][p.x] < fvisited[p.y][p.x])
                min = Math.min(jvisited[p.y][p.x], min);
        }

        if(min == 10000000)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(min);
    }
}
