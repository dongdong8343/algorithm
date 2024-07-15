import java.util.*;
import java.io.*;
public class Baekjoon19532 {
    static int[] a = new int[10];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = -999; i <= 999; i++){
            for(int j = -999; j <= 999; j++){
                if(a[0] * i + a[1] * j == a[2] && a[3] * i + a[4] * j == a[5]){
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}