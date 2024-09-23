import java.io.*;
import java.util.*;
public class BaekjoonRe17837_4 {
    static class Mal{
        int y, x, d;
        Mal(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static int n, k, y, x, d;
    static int[][] a = new int[16][16];
    static List<Integer>[][] board = new List[16][16];
    static Mal[] mal = new Mal[14];
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static void go(){
        while(true){
            if(cnt > 1000) {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
            for(int i = 1; i <= k; i++){
                int y = mal[i].y;
                int x = mal[i].x;
                int ny = y + dy[mal[i].d];
                int nx = x + dx[mal[i].d];
                if(ny < 0 || nx < 0|| ny >= n || nx >= n || a[ny][nx] == 2){
                    mal[i].d ^= 1;
                    ny = y + dy[mal[i].d];
                    nx = x + dx[mal[i].d];
                    if(ny < 0 || nx < 0|| ny >= n || nx >= n || a[ny][nx] == 2) continue;
                }
                List<Integer> li = new ArrayList<>();
                boolean flag = false;
                for(int temp : board[mal[i].y][mal[i].x]){
                    if(temp == i || flag) {
                        flag = true;
                        li.add(temp);
                    }
                }
                if(a[ny][nx] == 1) Collections.reverse(li);
                for(int temp : li) {
                    board[y][x].remove((Integer)temp);
                    board[ny][nx].add(temp);
                    mal[temp].y = ny;
                    mal[temp].x = nx;
                }
                if(board[ny][nx].size() >= 4) {
                    System.out.println(cnt);
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
                a[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new ArrayList<>();
            }
        }
        for(int i = 1; i <= k; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken()) - 1;
            mal[i] = new Mal(y, x, d);
            board[y][x].add(i);
        }
        go();
    }
}