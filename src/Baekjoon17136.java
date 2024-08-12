import java.util.*;
import java.io.*;
public class Baekjoon17136 {
    static int n = 10, ret = 987654321;
    static int[][] a = new int[14][14];
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static boolean check(int y, int x, int size){
        if(y + size > n || x + size > n) return false;
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(a[i][j] == 0) return false;
            }
        }
        return true;
    }
    static void draw(int y, int x, int size, int value){
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                a[i][j] = value;
            }
        }
    }
    static void go(int y, int x, int cnt){
        if(cnt >= ret) return;
        if(x == n){
            go(y + 1, 0, cnt);
            return;
        }
        if(y == n){
            ret = Math.min(ret, cnt);
            return;
        }
        if(a[y][x] == 0){
            go(y, x + 1, cnt);
            return;
        }
        for(int i = 5; i >= 1; i--){
            if(mp.getOrDefault(i, 0) == 5) continue;
            if(check(y, x, i)){
                mp.put(i, mp.getOrDefault(i, 0) + 1);
                draw(y, x, i, 0);
                go(y, x + i, cnt + 1);
                draw(y, x, i, 1);
                mp.put(i, mp.getOrDefault(i, 0) - 1);
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0);
        System.out.println(ret == 987654321 ? -1 : ret);
    }
}