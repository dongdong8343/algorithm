import java.util.*;
import java.io.*;
public class Baekjoon17837 {
    static int n, k, ret = 0;
    static int[][] a = new int[16][16];
    static Mal[] mal = new Mal[14];
    static class Mal{
        int y, x, d;
        Mal(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static List<Integer>[][] board = new List[16][16];
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
                int ny = mal[i].y + dy[mal[i].d];
                int nx = mal[i].x + dx[mal[i].d];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2){
                    mal[i].d ^= 1;

                    ny = mal[i].y + dy[mal[i].d];
                    nx = mal[i].x + dx[mal[i].d];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) continue;
                }

                List<Integer> li = new ArrayList<>();
                boolean found = false;
                for(int s = 0; s < board[mal[i].y][mal[i].x].size(); s++){
                    int temp = board[mal[i].y][mal[i].x].get(s);
                    if(temp == i) found = true;
                    if(found) li.add(temp);
                }

                for(int s = li.size() - 1; s >= 0; s--){
                    board[mal[i].y][mal[i].x].remove(Integer.valueOf(li.get(s)));
                }

                if(a[ny][nx] == 1) Collections.reverse(li);

                for(int s : li){
                    board[ny][nx].add(s);
                    mal[s].y = ny;
                    mal[s].x = nx;
                }

                if(board[ny][nx].size() >= 4){
                    return;
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