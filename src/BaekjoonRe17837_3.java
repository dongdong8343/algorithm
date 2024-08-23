import java.util.*;
import java.io.*;
public class BaekjoonRe17837_3 {
    static int n, k, ret = 0;
    static int[][] map = new int[16][16];
    static class Mal{
        int y, x, d;
        Mal(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static Mal[] mal = new Mal[14];
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static List<Integer>[][] a = new List[16][16];
    static void go(){
        while(true){
            ret++;
            if(ret > 1000){
                System.out.println(-1);
                System.exit(0);
            }
            for(int i = 1; i <= k; i++){
                int y = mal[i].y;
                int x = mal[i].x;
                int ny = mal[i].y + dy[mal[i].d];
                int nx = mal[i].x + dx[mal[i].d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2){
                    mal[i].d ^= 1;
                    ny = mal[i].y + dy[mal[i].d];
                    nx = mal[i].x + dx[mal[i].d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2)
                        continue;
                }
                boolean flag = false;
                List<Integer> li = new ArrayList<>();
                for(int t : a[y][x]){
                    if(t == i) flag = true;
                    if(flag) li.add(t);
                }
                for(int t : li){
                    a[y][x].remove((Integer)t);
                    mal[t].y = ny;
                    mal[t].x = nx;
                }
                if(map[ny][nx] == 1) Collections.reverse(li);
                for(int t : li) a[ny][nx].add(t);
                if(a[ny][nx].size() >= 4){
                    System.out.println(ret);
                    System.exit(0);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = new ArrayList<>();
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            mal[i] = new Mal(y, x, d);
            a[y][x].add(i);
        }
        go();
    }
}