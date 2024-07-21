import java.util.*;
import java.io.*;
public class BaekjoonRe17406_2 {
    static int n, m, k, ret = 987654321;
    static class Info{
        int r, c, s;
        Info(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static List<Info> li = new ArrayList<>();
    static int[][] a = new int[54][54];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static void go(int depth, List<Info> li){
        if(depth == k){
            rotate();
            return;
        }
        for(int i = depth; i < k; i++){
            Collections.swap(li, i, depth);
            go(depth + 1, li);
            Collections.swap(li, i, depth);
        }
    }
    static int[][] copy(){
        int[][] temp = new int[54][54];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }
    static void rotate(){
        int[][] temp = copy();
        for(Info t : li){
            for(int i = 1; i <= t.s; i++){
                int sy = t.r - i;
                int sx = t.c - i;
                int ey = t.r + i;
                int ex = t.c + i;
                int y = sy; int x = sx;
                Deque<Integer> q = new ArrayDeque<>();
                q.add(temp[sy][sx]);
                int idx = 0;
                while(true){
                    int ny = y + dy[idx];
                    int nx = x + dx[idx];
                    if(ny < sy || nx < sx || ny > ey || nx > ex){
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx) {
                        break;
                    }
                    q.addLast(temp[ny][nx]);
                    y = ny; x = nx;
                }
                q.addFirst(q.pollLast());
                y = sy;
                x = sx;
                idx = 0;
                temp[sy][sx] = q.pollFirst();
                while(true){
                    int ny = y + dy[idx];
                    int nx = x + dx[idx];
                    if(ny < sy || nx < sx || ny > ey || nx > ex){
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx) break;
                    temp[ny][nx] = q.pollFirst();
                    y = ny;
                    x = nx;
                }
            }
        }
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < m; j++){
                sum += temp[i][j];
            }
            ret = Math.min(ret, sum);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            li.add(new Info(r - 1, c - 1, s));
        }
        go(0, li);
        System.out.println(ret);
    }
}