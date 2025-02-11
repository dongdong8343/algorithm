import java.io.*;
import java.util.*;
import java.awt.Point;

public class Baekjoon7576 {
    static int ret = -1, cnt = 0, n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board = new int[1004][1004];
    static Queue<Point> a = new LinkedList<>();
    static Queue<Point> b = new LinkedList<>();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    a.add(new Point(j, i));
                } else if(board[i][j] == 0) cnt++;
            }
        }

        if(cnt == 0){
            System.out.println(0);
            return;
        }

        bfs();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ret);
    }

    static void bfs(){
        while(!a.isEmpty()){
            ret++;
            b = a;
            a = new LinkedList<>();
            while(!b.isEmpty()){
                Point p = b.poll();
                int x = p.x, y = p.y;
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || ny < 0 || ny >= n || nx >= m || board[ny][nx] != 0){
                        continue;
                    }
                    a.add(new Point(nx, ny));
                    board[ny][nx] = 1;
                }
            }
        }
    }
}