import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReRe4179 {
    static char[][] map = new char[1004][1004];
    static int[][] vj = new int[1004][1004];
    static int[][] vf = new int[1004][1004];
    static Queue<Point> qj = new LinkedList<>();
    static Queue<Point> qf = new LinkedList<>();
    static int n, m, min = 987654321, ok = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Point> escape = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                vf[i][j] = 1004;
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J') {
                    qj.add(new Point(j, i));
                    vj[i][j] = 1;
                }
                else if(map[i][j] == 'F') {
                    qf.add(new Point(j, i));
                    vf[i][j] = 1;
                }
            }
        }
        while(!qj.isEmpty()){
            Point p = qj.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                    escape.add(new Point(p.x, p.y));
                    continue;
                }
                if(vj[ny][nx] == 0 && map[ny][nx] == '.'){
                    vj[ny][nx] = vj[p.y][p.x] + 1;
                    qj.add(new Point(nx, ny));
                }
            }
        }
        while(!qf.isEmpty()){
            Point p = qf.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || vf[ny][nx] != 1004) continue;
                if(map[ny][nx] != '#'){
                    vf[ny][nx] = vf[p.y][p.x] + 1;
                    qf.add(new Point(nx, ny));
                }
            }
        }
        for(Point p : escape){
            if(vj[p.y][p.x] < vf[p.y][p.x]){
                ok = 1;
                min = Math.min(min, vj[p.y][p.x]);
            }
        }
        if(ok == 1) System.out.println(min);
        else System.out.println("IMPOSSIBLE");
    }
}