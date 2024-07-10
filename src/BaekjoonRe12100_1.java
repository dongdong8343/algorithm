import java.util.*;
import java.io.*;
public class BaekjoonRe12100_1 {
    static int n, ret = 0;
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
            int[][] temp = new int[24][24];
            for(int i = 0; i < n; i++){
                int idx = -1;
                boolean b = false;
                for(int j = 0; j < n; j++){
                    if(a[i][j] == 0) continue;
                    if(b && temp[i][idx] == a[i][j]){
                        temp[i][idx] *= 2;
                        b = false;
                    }else{
                        temp[i][++idx] = a[i][j];
                        b = true;
                    }
                }
                for(idx++; idx < n; idx++) temp[i][idx] = 0;
            }
            a = temp;
        }
    }
    static void go(int cnt, Board b){
        if(cnt == 5){
            get_max(b.a);
            return;
        }
        for(int i = 0; i < 4; i++){
            Board t = new Board();
            t.a = copy(b.a);
            t.move();
            go(cnt + 1, t);
            b.rotate();
        }
    }
    static void get_max(int[][] t){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret = Math.max(ret, t[i][j]);
            }
        }
    }
    static int[][] copy(int[][] t){
        int[][] temp = new int[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = t[i][j];
            }
        }
        return t;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Board board = new Board();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board.a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, board);
        System.out.println(ret);
    }
}