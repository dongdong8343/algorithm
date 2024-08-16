import java.util.*;
import java.io.*;
public class BaekjoonRe17837_2 {
    static int n, k, turn = 0;
    static int[][] a = new int[16][16];
    static List<Integer>[][] board = new List[16][16];
    static Mal[] mal = new Mal[14];
    static class Mal{
        int y, x, d;
        Mal(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
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
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            mal[i] = new Mal(y, x, d);
            board[y][x].add(i);
        }
        while(true){
            turn++;
            if(turn > 1000) {
                System.out.println(-1);
                return;
            }
            for(int i = 1; i <= k; i++){
                int ny = mal[i].y + dy[mal[i].d];
                int nx = mal[i].x + dx[mal[i].d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2){
                    mal[i].d ^= 1;
                    ny = mal[i].y + dy[mal[i].d];
                    nx = mal[i].x + dx[mal[i].d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) continue;
                }
                boolean flag = false;
                List<Integer> li = new ArrayList<>();
                for(int x : board[mal[i].y][mal[i].x]){
                    if(i == x) flag = true;
                    if(flag) {
                        li.add(x);
                    }
                }
                for(int x : li) board[mal[i].y][mal[i].x].remove(Integer.valueOf(x));
                if(a[ny][nx] == 1) Collections.reverse(li);
                for(int x : li) {
                    board[ny][nx].add(x);
                    mal[x].y = ny; mal[x].x = nx;
                }
                if(board[ny][nx].size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }
        }
    }
}