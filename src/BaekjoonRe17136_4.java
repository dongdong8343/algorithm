import java.util.*;
import java.io.*;
public class BaekjoonRe17136_4 {
    static int[][] a  =new int[14][14];
    static int ret = 987654321;
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static void go(int y, int x, int cnt){
        if(cnt >= ret) return;
        if(x == 10){
            go(y + 1, 0, cnt);
            return;
        }
        if(y == 10){
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
    static boolean check(int y, int x, int size){
        if(y + size > 10 || x + size > 10) return false;
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
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, 0);
        System.out.println(ret == 987654321 ? -1 : ret);
    }
}