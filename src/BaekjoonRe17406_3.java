import java.util.*;
import java.io.*;
public class BaekjoonRe17406_3 {
    static int n, m, k, ret = 987654321;
    static int[][] a = new int[54][54];
    static List<Info> li = new ArrayList<>();
    static class Info{
        int r, c, s;
        Info(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static void go(int depth, List<Info> li){
        if(depth == k){
            rotate(li);
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

    static void rotate(List<Info> li){
        int[][] temp = copy();
        for(Info p : li){
            for(int i = 1; i <= p.s; i++){
                Deque<Integer> dq = new ArrayDeque<>();
                int idx = 0;
                int sy = p.r - i;
                int sx = p.c - i;
                int ey = p.r + i;
                int ex = p.c + i;
                int nx, ny, y = sy, x = sx;
                dq.add(temp[sy][sx]);
                while(true){
                    ny = y + dy[idx];
                    nx = x + dx[idx];
                    if(ey < ny || ex < nx || ny < sy || nx < sx){
                        idx++;
                        ny = y + dy[idx];
                        nx = x + dx[idx];
                    }
                    if(ny == sy && nx == sx) break;
                    dq.add(temp[ny][nx]);
                    y = ny; x = nx;
                }
                y = sy; x = sx; idx = 0;
                dq.addFirst(dq.pollLast());
                temp[y][x] = dq.pollFirst();
                while(true){
                    ny = y + dy[idx];
                    nx = x + dx[idx];
                    if(ey < ny || ex < nx || ny < sy || nx < sx){
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
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < m; j++){
                sum += temp[i][j];
            }
            ret = Math.min(sum, ret);
        }
    }
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
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
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            li.add(new Info(r, c, s));
        }
        go(0, li);
        System.out.println(ret);
    }
}