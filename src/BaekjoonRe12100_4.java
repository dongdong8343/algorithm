import java.util.*;
import java.io.*;
public class BaekjoonRe12100_4{
    static int n, ret = -987654321;
    static int[][] a = new int[24][24];
    static int[][] copy(int[][] arr){
        int[][] temp = new int[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    static int[][] rotate(int[][] temp){
        int[][] t = new int[24][24];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                t[i][j] = temp[n - j - 1][i];
            }
        }
        return t;
    }
    static void go(int[][] arr, int cnt){
        if(cnt >= 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ret = Math.max(arr[i][j], ret);
                }
            }
            return;
        }
        for(int t = 0; t < 4; t++){
            int[][] temp = copy(arr);
            for(int i = 0; i < n; i++){
                boolean flag = false;
                int c = -1;
                for(int j = 0; j < n; j++){
                    if(temp[i][j] == 0) continue;
                    if(c != -1 && flag && temp[i][c] == temp[i][j]){
                        temp[i][c] *= 2;
                        flag = false;
                    }else{
                        temp[i][++c] = temp[i][j];
                        flag = true;
                    }
                }
                for(int k = ++c; k < n; k++) temp[i][k] = 0;
            }
            go(temp, cnt + 1);
            arr = rotate(arr);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(a, 0);
        System.out.println(ret);
    }
}