import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe17406_1 {
    static int n, m, k, ret = 987654312;
    static int[][] a = new int[54][54];
    static List<Info> li = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Info{
        int r, c, s;
        Info(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static void combi(int depth, List<Info> li){
        if(depth == k){
            rotate();
            return;
        }
        for(int i = depth; i < k; i++){
            Collections.swap(li, i, depth);
            combi(depth + 1, li);
            Collections.swap(li, i, depth);
        }
    }
    static int[][] copy(){
        int[][] temp = new int[54][54];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <  m; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }
    static void rotate(){
        int[][] temp = copy();
        for(Info p : li){
            for(int i = 1; i <= p.s; i++){
                Deque<Integer> dq = new ArrayDeque<>();
                int sy = p.r - i;
                int sx = p.c - i;
                int ey = p.r + i;
                int ex = p.c + i;
                int y = sy;
                int x = sx;
                dq.add(temp[y][x]);
                int idx = 0;
                while(true){
                    int ny = y + dy[idx];
                    int nx = x + dx[idx];
                    if(ny < sy || nx < sx || ny > ey || nx > ex){
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx)break;
                    dq.add(temp[ny][nx]);
                    y = ny;
                    x = nx;
                }
                dq.addFirst(dq.pollLast());
                y = sy;
                x = sx;
                idx = 0;
                temp[y][x] = dq.pollFirst();
                while(true){
                    int ny = y + dy[idx];
                    int nx = x + dx[idx];
                    if(ny < sy || nx < sx || ny > ey || nx > ex){
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx)break;
                    temp[ny][nx] = dq.pollFirst();
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            li.add(new Info(a - 1, b - 1, c));
        }
        combi(0, li);
        System.out.println(ret);
    }
}