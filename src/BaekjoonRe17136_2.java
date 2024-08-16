import java.util.*;
import java.io.*;
public class BaekjoonRe17136_2 {
    static final int n = 10;
    static int ret = 987654321;
    static int[][] a = new int[14][14];
    static HashMap<Integer, Integer> hs = new HashMap<>();
    static void go(int y, int x, int cnt){
        if(ret <= cnt) return;
        if(x >= n) {
            go(y + 1, 0, cnt);
            return;
        }
        if(y >= n) {
            ret = Math.min(ret, cnt);
            return;
        }
        if(a[y][x] == 0) {
            go(y, x + 1, cnt);
            return;
        }
        for(int size = 5; size >= 1; size--){
            if(hs.getOrDefault(size, 0) < 5){
                hs.put(size, hs.getOrDefault(size, 0) + 1);
                if(check(y, x, size)) {
                    draw(y, x, size, 0);
                    go(y, x + size, cnt + 1);
                    draw(y, x, size, 1);
                }
                hs.put(size, hs.getOrDefault(size, 0) - 1);
            }
        }
    }
    static void draw(int y, int x, int size, int num){
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                a[i][j] = num;
            }
        }
    }
    static boolean check(int y, int x, int size){
        if((y + size - 1) >= n || (x + size - 1) >= n) return false;
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(a[i][j] == 0) return false;
            }
        }
        return true;
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