import java.util.*;
import java.io.*;
public class Baekjoon2720 {
    static int t;
    static int[] a = {25, 10, 5, 1};
    static int[] ret = new int[4];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < 4; i++){
                ret[i] = n / a[i];
                n %= a[i];
            }
            for(int i = 0; i < 4; i++){
                System.out.print(ret[i] + " ");
            }
            System.out.println();
        }
    }
}