import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;
public class BaekjoonReRe14502 {
    static int[][] map = new int[12][12];
    static int[][] visited = new int[12][12];
    static int[][] virus = new int[12][12];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n, m;
    static List<Point> vr = new ArrayList<>();
    static List<Point> emp = new ArrayList<>();
    static void dfs(int y, int x){
        visited[y][x] = 1;
        virus[y][x] = 2;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(visited[ny][nx] != 1 && map[ny][nx] == 0)
                dfs(ny, nx);
        }
    }
    static void go(){
        visited = new int[12][12];
        virus = new int[12][12];
        for(Point p : vr)
            virus[p.y][p.x] = 2;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] != 1 && virus[i][j] == 2){
                    dfs(i, j);
                }
            }
        }
    }
    static int check(){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0 && virus[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0 || temp == 1){
                    if(temp == 0)
                        emp.add(new Point(j, i));
                    map[i][j] = temp;
                }
                else
                    vr.add(new Point(j, i));
            }
        }

        int ret = -1;
        for(int i = 0; i < emp.size(); i++){
            for(int j = i + 1; j < emp.size(); j++){
                for(int k = j + 1; k < emp.size(); k++){
                    map[emp.get(i).y][emp.get(i).x] = 1;
                    map[emp.get(j).y][emp.get(j).x] = 1;
                    map[emp.get(k).y][emp.get(k).x] = 1;
                    go();
                    ret = Math.max(ret, check());
                    map[emp.get(i).y][emp.get(i).x] = 0;
                    map[emp.get(j).y][emp.get(j).x] = 0;
                    map[emp.get(k).y][emp.get(k).x] = 0;
                }
            }
        }

        System.out.println(ret);
    }
}
