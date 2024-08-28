import java.util.*;
import java.io.*;
public class BaekjoonRe17136_3 {
    static int[][] a = new int[14][14];
    static int ret = 987654321;
    static HashMap<Integer, Integer> hs = new HashMap<>();
    static final int n = 10;
    static void go(int y, int x, int cnt){
        if(ret <= cnt) return;
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
            if(hs.getOrDefault(i, 0) >= 5) continue;
            if(check(y, x, i)){
                draw(y, x, i, 0);
                hs.put(i, hs.getOrDefault(i, 0) + 1);
                go(y, x + i, cnt + 1);
                hs.put(i, hs.getOrDefault(i, 0) - 1);
                draw(y, x, i, 1);
            }
        }
    }
    static boolean check(int y, int x, int size){
        if(y + size - 1 >= n || x + size - 1 >= n) return false;
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(a[i][j] == 0) return false;
            }
        }
        return true;
    }
    static void draw(int y, int x, int size, int num){
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                a[i][j] = num;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0);
        if(ret == 987654321) System.out.println(-1);
        else System.out.println(ret);
    }
}