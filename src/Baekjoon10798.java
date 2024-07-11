import java.util.*;
import java.io.*;
public class Baekjoon10798 {
    static int max = 0;
    static char[][] a = new char[5][15];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 15; j++){
                a[i][j] = ' ';
            }
        }
        for(int i = 0; i < 5; i++){
            String s = br.readLine();
            max = Math.max(max, s.length());
            for(int j = 0; j < s.length(); j++){
                a[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < max; i++){
            for(int j = 0; j < 5; j++){
                if(a[j][i] == ' ') continue;
                System.out.print(a[j][i]);
            }
        }
    }
}