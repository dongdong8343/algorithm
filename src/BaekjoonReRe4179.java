import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReRe4179 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[1004][1004];
        int[][] jv = new int[1004][1004];
        int[][] fv = new int[1004][1004];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        Queue<Point> jq = new LinkedList<>();
        Queue<Point> fq = new LinkedList<>();
        List<Point> li = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                fv[i][j] = 10000;
                if(map[i][j] == 'J'){
                    jq.add(new Point(j, i));
                    jv[i][j] = 1;
                }
                else if(map[i][j] == 'F'){
                    fq.add(new Point(j, i));
                    fv[i][j] = 1;
                }
            }
        }

        while(!jq.isEmpty()){
            Point p = jq.poll();
            for(int i = 0; i < 4; i++){
                int ny = dy[i] + p.y;
                int nx = dx[i] + p.x;
                if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                    li.add(new Point(p.x, p.y));
                    continue;
                }
                if(jv[ny][nx] == 0 && map[ny][nx] == '.'){
                    jv[ny][nx] = jv[p.y][p.x] + 1;
                    jq.add(new Point(nx, ny));
                }
            }
        }

        while(!fq.isEmpty()){
            Point p = fq.poll();
            for(int i = 0; i < 4; i++){
                int ny = dy[i] + p.y;
                int nx = dx[i] + p.x;
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(fv[ny][nx] == 10000 && map[ny][nx] != '#'){
                    fv[ny][nx] = fv[p.y][p.x] + 1;
                    fq.add(new Point(nx, ny));
                }
            }
        }

        for(Point p : li){
            if(jv[p.y][p.x] < fv[p.y][p.x]){
                System.out.println(jv[p.y][p.x]);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}