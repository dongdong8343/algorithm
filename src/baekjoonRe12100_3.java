import java.util.*;
import java.io.*;
public class baekjoonRe12100_3 {
    static int n, ret = 0;
    static void go(Board t, int cnt){
        if(cnt == 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ret = Math.max(ret, t.arr[i][j]);
                }
            }
            return;
        }
        for(int s = 0; s < 4; s++){
            Board temp = new Board();
            temp.arr = copy(t.arr);
            temp.move();
            go(temp, cnt + 1);
            t.rotate();
        }
    }
    static int[][] copy(int[][] t){
        int[][] temp = new int[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = (t[i][j]);
            }
        }
        return temp;
    }
    static class Board{
        int[][] arr = new int[24][24];
        void move(){
            for(int i = 0; i < n; i++){
                int c = -1; boolean flag = false;
                for(int j = 0; j < n; j++){
                    if(c != -1 && !flag && arr[i][j] == arr[i][c]){
                        arr[i][c] *= 2;
                        flag = true;
                    }else if(arr[i][j] != 0){
                        flag = false;
                        arr[i][++c] = arr[i][j];
                    }
                }
                for(++c; c < n; c++) arr[i][c] = 0;
            }
        }
        void rotate(){
            int[][] temp = new int[24][24];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    temp[i][j] = arr[n - j - 1][i];
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = temp[i][j];
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Board a = new Board();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a.arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(a, 0);
        System.out.println(ret);
    }
}