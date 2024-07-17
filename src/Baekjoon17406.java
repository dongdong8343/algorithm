import java.util.*;
import java.io.*;
public class Baekjoon17406 {
    static class Info{
        int r, c, s;
        Info(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static int n, m, k, ret = 987654321;
    static int[][] a = new int[54][54];
    static List<Info> li = new ArrayList<>();
    static void make(int depth, List<Info> li){
        if(depth == k){
            rotate(li);
        }
        for(int i = depth; i < k; i++){
            Collections.swap(li, i, depth);
            make(depth + 1, li);
            Collections.swap(li, i, depth);
        }
    }
    static void rotate(List<Info> li){
        int[][] temp = copy();
        for(Info t : li){
            for(int j = 1; j <= t.s; j++){
                int sy = t.r - j - 1;
                int sx = t.c - j - 1;
                int ey = t.r + j - 1;
                int ex = t.c + j - 1;
                Deque<Integer> dq = new ArrayDeque<>();
                for(int i = sx; i < ex; i++) {
                    dq.add(temp[sy][i]);
                }
                for(int i = sy; i < ey; i++) {
                    dq.add(temp[i][ex]);
                }
                for(int i = ex; i > sx; i--) {
                    dq.add(temp[ey][i]);
                }
                for(int i = ey; i > sy; i--) {
                    dq.add(temp[i][sx]);
                }
                dq.addFirst(dq.pollLast());
                for(int i = sx; i < ex; i++) temp[sy][i] = dq.poll();
                for(int i = sy; i < ey; i++) temp[i][ex] = dq.poll();
                for(int i = ex; i > sx; i--) temp[ey][i] = dq.poll();
                for(int i = ey; i > sy; i--) temp[i][sx] = dq.poll();
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
    static int[][] copy(){
        int[][] temp = new int[54][54];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
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
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            li.add(new Info(r, c, s));
        }
        make(0, li);
        System.out.println(ret);
    }
}