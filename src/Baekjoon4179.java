import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon4179 {
    static int r, c;
    static Point js, fs;
    static char[][] map;
    static int[][] fVisited;
    static int[][] jVisited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Point> li = new ArrayList<>();
    static Queue<Point> fire = new LinkedList<>();
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        fVisited = new int[r][c];
        jVisited = new int[r][c];

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                fVisited[i][j] = 10000;
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J'){
                    q.add(new Point(j, i));
                    js = new Point(j, i);
                    jVisited[i][j] = 1;
                }
                else if(map[i][j] == 'F') {
                    fire.add(new Point(j, i));
                    fVisited[i][j] = 1;
                }
            }
        }

        while(!fire.isEmpty()){
            Point temp = fire.poll();
            int y = temp.y;
            int x = temp.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || fVisited[ny][nx] != 10000 || map[ny][nx] == '#') continue;
                fVisited[ny][nx] = fVisited[y][x] + 1;
                fire.add(new Point(nx, ny));
            }
        }

        int ret = 10000000;

        while(!q.isEmpty()){
            Point temp = q.poll();
            int y = temp.y;
            int x = temp.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c){
                    if(jVisited[y][x] < fVisited[y][x])
                        ret = Math.min(ret, jVisited[y][x]);
                    continue;
                }
                if(jVisited[ny][nx] != 0 || map[ny][nx] == '#') continue;
                jVisited[ny][nx] = jVisited[y][x] + 1;
                q.add(new Point(nx, ny));
            }
        }
        if(ret == 10000000)
            System.out.println("IMPOSSIBLE");
        else System.out.println(ret);
    }
}
