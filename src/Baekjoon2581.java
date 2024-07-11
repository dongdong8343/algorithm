import java.util.*;
import java.io.*;
public class Baekjoon2581 {
    static boolean get = false;
    static boolean[] che = new boolean[10004];
    static int min = 987654321, sum = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        che[1] = true;
        for(int i = 2; i <= 10000; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= 10000; j += i){
                che[j] = true;
            }
        }
        for(int i = n; i <= m; i++){
            if(!che[i]) {
                if(!get){
                    get = true;
                    min = i;
                }
                sum += i;
            }
        }
        if(sum == 0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}