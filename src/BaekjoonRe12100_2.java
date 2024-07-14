import java.util.*;
import java.io.*;
public class BaekjoonRe12100_2 {
    static int n, ret = 0;
    static void go(int cnt, Board b){
        if(cnt == 5){
            b.get_max();
            return;
        }
        for(int s = 0; s < 4; s++){
            Board t = new Board();
            t.a = copy(b.a);
            t.move();
            go(cnt + 1, t);
            b.rotate();
        }
    }
    static int[][] copy(int[][] b){
        int[][] t = new int[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                t[i][j] = b[i][j];
            }
        }
        return t;
    }
    static class Board{
        int[][] a = new int[24][24];
        void move(){
            int[][] t = new int[24][24];
            for(int i = 0; i < n; i++){
                int c = -1; boolean flag = false;
                for(int j = 0; j < n; j++){
                    if(a[i][j] == 0) continue;
                    if(flag && t[i][c] == a[i][j]) {
                        t[i][c] *= 2;
                        flag = false;
                    }
                    else {
                        flag = true;
                        t[i][++c] = a[i][j];
                    }
                }
                for(c++; c < n; c++) t[i][c] = 0;
            }
            a = t;
        }
        void rotate(){
            int[][] t = new int[24][24];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    t[i][j] = a[n - j - 1][i];
                }
            }
            a = t;
        }
        void get_max(){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ret = Math.max(ret, a[i][j]);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Board b = new Board();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                b.a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, b);
        System.out.println(ret);
    }
}