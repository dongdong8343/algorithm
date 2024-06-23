import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReReRe4179 {
    static int r, c, ret = 987654321;
    static char[][] map = new char[1004][1004];
    static Queue<Point> jh = new LinkedList<>();
    static Queue<Point> fire = new LinkedList<>();
    static List<Point> li = new ArrayList<>();
    static int[][] jv = new int[1004][1004];
    static int[][] fv = new int[1004][1004];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
                fv[i][j] = 987654321;
                if(map[i][j] == 'J') {
                    jh.add(new Point(j, i));
                    jv[i][j] = 1;
                }
                else if(map[i][j] == 'F') {
                    fire.add(new Point(j, i));
                    fv[i][j] = 1;
                }
            }
        }

        while(!jh.isEmpty()){
            Point temp = jh.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c){
                    li.add(new Point(temp.x, temp.y));
                    continue;
                }
                if(jv[ny][nx] != 0) continue;
                if(map[ny][nx] == '.'){
                    jv[ny][nx] = jv[temp.y][temp.x] + 1;
                    jh.add(new Point(nx, ny));
                }
            }
        }

        while(!fire.isEmpty()){
            Point temp = fire.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || fv[ny][nx] != 987654321 || map[ny][nx] == '#') continue;
                fv[ny][nx] = fv[temp.y][temp.x] + 1;
                fire.add(new Point(nx, ny));
            }
        }

        for(Point p : li){
            if(jv[p.y][p.x] < fv[p.y][p.x]) ret = Math.min(ret, jv[p.y][p.x]);
        }

        if(ret == 987654321) System.out.println("IMPOSSIBLE");
        else System.out.println(ret);
    }
}
