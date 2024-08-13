import java.util.*;
import java.io.*;
public class BaekjoonRe17837_1 {
    static int n, k, ret = 0;
    static int[][] a = new int[16][16];
    static List<Integer>[][] board = new List[16][16];
    static class Mal{
        int y, x, d;
        Mal(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static Mal[] mal = new Mal[13];
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
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
                int d = mal[i].d;
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2){
                    mal[i].d ^= 1;
                    ny = y + dy[mal[i].d];
                    nx = x + dx[mal[i].d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) continue;
                }
                boolean flag = false;
                List<Integer> li = new ArrayList<>();
                for(int s = 0; s < board[y][x].size(); s++){
                    int temp = board[y][x].get(s);
                    if(i == temp) flag = true;
                    if(flag) li.add(temp);
                }
                for(int s = 0; s < li.size(); s++) board[y][x].remove(li.get(s));
                if(a[ny][nx] == 1) Collections.reverse(li);
                for(int t : li) {
                    board[ny][nx].add(t);
                    mal[t].y = ny;
                    mal[t].x = nx;
                }
                if(board[ny][nx].size() >= 4) return;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
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
        go();
        System.out.println(ret);
    }
}