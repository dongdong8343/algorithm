import java.util.*;
import java.io.*;
public class BaekjoonRe17406_4 {
    static int n, m, k, ret = 987654321;
    static int[][] a = new int[104][104];
    static List<Info> li = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static class Info{
        int r, c, s;
        Info(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static void go(int depth, List<Info> li){
        if(depth == k) rotate(li);
        for(int i = depth; i < k; i++){
            Collections.swap(li, depth, i);
            go(depth + 1, li);
            Collections.swap(li, depth, i);
        }
    }
    static int[][] copy(int[][] a){
        int[][] temp = new int[104][104];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }
    static void rotate(List<Info> li){
        int[][] temp = copy(a);
        for(Info t : li){
            for(int i = 1; i <= t.s; i++){
                int sy = t.r - i;
                int sx = t.c - i;
                int ey = t.r + i;
                int ex = t.c + i;
                int y = sy; int x = sx; int idx = 0;
                Deque<Integer> dq = new ArrayDeque<>();
                dq.add(temp[sy][sx]);
                while(true){
                    int ny = y + dy[idx];
                    int nx = x + dx[idx];
                    if(ny < sy || nx < sx || ny > ey || nx > ex) {
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx) break;
                    dq.addLast(temp[ny][nx]);
                    y = ny; x = nx;
                }
                dq.addFirst(dq.pollLast());
                y = sy; x = sx; idx = 0;
                temp[y][x] = dq.pollFirst();
                while(true){
                    int ny = y + dy[idx];
                    int nx = x + dx[idx];
                    if(ny < sy || nx < sx || ny > ey || nx > ex) {
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx) break;
                    temp[ny][nx] = dq.pollFirst();
                    y = ny; x = nx;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= m; j++){
                sum += temp[i][j];
            }
            ret = Math.min(sum, ret);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            li.add(new Info(r, c, s));
        }
        go(0, li);
        System.out.println(ret);
    }
}