import java.util.*;
import java.io.*;
public class Baekjoon12100 {
    static int ret = 0, n;
    static class Board{
        int[][] a = new int[24][24];
        void rotate(){
            int[][] t = new int[24][24];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    t[i][j] = a[n - j - 1][i];
                }
            }
            a = t;
        }
        void move(){
            int[][] t = new int[24][24];
            for(int i = 0; i < n; i++){
                int have = 0, c = -1;
                for(int j = 0; j < n; j++){
                    if(a[i][j] == 0) continue;
                    if(have == 1 && a[i][j] == t[i][c]){
                        t[i][c] *= 2;
                        have = 0;
                    }else {
                        t[i][++c] = a[i][j];
                        have = 1;
                    }
                }
                for(c++; c < n; c++) t[i][c] = 0;
            }
            a = t;
        }
    }
    static int[][] copy(int[][] t){
        int[][] temp = new int[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = t[i][j];
            }
        }
        return temp;
    }
    static void get_max(int[][] t){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret = Math.max(ret, t[i][j]);
            }
        }
    }
    static void go(Board b, int cnt){
        if(cnt == 5){
            get_max(b.a);
            return;
        }
        for(int i = 0; i < 4; i++){
            Board temp = new Board();
            temp.a = copy(b.a);
            temp.move();
            go(temp, cnt + 1);
            b.rotate();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Board board = new Board();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board.a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(board, 0);
        System.out.println(ret);
    }
}
