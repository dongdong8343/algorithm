import java.io.*;
import java.util.*;
public class Baekjoon1992 {
    static int[][] map = new int[68][68];
    static String go(int y, int x, int size){
        if(size == 1)
            return String.valueOf(map[y][x]);
        String s = String.valueOf(map[y][x]);
        StringBuilder sb = new StringBuilder();
        for(int i = y; i < size + y; i++){
            for(int j = x; j < size + x; j++){
                if(!String.valueOf(map[i][j]).equals(s)){
                    sb.append('(');
                    sb.append(go(y,x,size/2));
                    sb.append(go(y, x + size/2, size/2));
                    sb.append(go(y+size/2, x, size/2));
                    sb.append(go(y+size/2, x+size/2, size/2));
                    sb.append(')');
                    return sb.toString();
                }
            }
        }
        return s;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        System.out.println(go(0, 0, n));
    }
}
