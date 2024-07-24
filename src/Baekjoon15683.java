import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon15683 {
    static List<Point> li = new ArrayList<>();
    static class Cctv{
        int k, d = 0, y, x;
        List<Integer>[] see = new List[4];
        Cctv(int y, int x, int k){
            this.y = y;
            this.x = x;
            this.k = k;
            for(int i = 0; i < 4; i++) see[i] = new ArrayList<>();
            if(k == 1){
                for(int i = 0; i < 4; i++){
                    see[i].add(i);
                }
            }else if(k == 2){
                see[0].add(3); see[0].add(1);
                see[1].add(0); see[1].add(2);
            } else if(k == 3){
                see[0].add(0); see[0].add(1);
                see[1].add(1); see[1].add(2);
                see[2].add(2); see[2].add(3);
                see[3].add(0); see[3].add(3);
            } else if(k == 4){
                see[0].add(0); see[0].add(1); see[0].add(3);
                see[1].add(0); see[1].add(1); see[1].add(2);
                see[2].add(1); see[2].add(2); see[2].add(3);
                see[3].add(0); see[3].add(2); see[3].add(3);
            } else if(k == 5){
                see[0].add(0); see[0].add(1); see[0].add(2); see[0].add(3);
            }
        }
    }
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void go(int here){
        if(here == cnt){
            int[][] temp = new int[12][12];
            for(Point p : li) temp[p.y][p.x] = 6;
            for(int i = 0; i < cnt; i++){
                int d = cctv[i].d;
                temp[cctv[i].y][cctv[i].x] = 1;
                for(int t : cctv[i].see[d]){
                    int y = cctv[i].y;
                    int x = cctv[i].x;
                    int ny, nx;
                    while (true) {
                        ny = y + dy[t];
                        nx = x + dx[t];
                        if(ny < 0 || nx < 0 || ny >= n || nx >= m || temp[ny][nx] == 6) break;
                        temp[ny][nx] = 1;
                        y = ny;
                        x = nx;
                    }
                }
            }
            int sum = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(temp[i][j] == 0) sum++;
                }
            }
            ret = Math.min(sum, ret);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(cctv[here].k == 2 && i == 2) break;
            if(cctv[here].k == 5 && i == 1) break;
            cctv[here].d += i;
            go(here + 1);
            cctv[here].d -= i;
        }
    }
    static int n, m, cnt = 0, idx = 0, ret = 987654321;
    static int[][] a = new int[12][12];
    static Cctv[] cctv = new Cctv[12];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m ; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == 6) li.add(new Point(j, i));
                if(a[i][j] >= 1 && a[i][j] <= 5){
                    cnt++;
                    cctv[idx++] = new Cctv(i, j, a[i][j]);
                }
            }
        }
        go(0);
        System.out.println(ret);
    }
}
