import java.util.*;
import java.io.*;
public class BaekjoonRe1992 {
    static int[][] map = new int[68][68];
    static int n;
    static String go(int y, int x, int size){
        StringBuilder sb = new StringBuilder();
        if(size == 1){
            sb.append(map[y][x]);
            return sb.toString();
        }
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(map[y][x] != map[i][j]){
                    sb.append('(');
                    sb.append(go(y, x, size/2));
                    sb.append(go(y, x + size/2, size/2));
                    sb.append(go(y + size/2, x, size/2));
                    sb.append(go(y + size/2, x + size/2, size/2));
                    sb.append(')');
                    return sb.toString();
                }
            }
        }
        return String.valueOf(map[y][x]);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        System.out.println(go(0, 0, n));
    }
}
