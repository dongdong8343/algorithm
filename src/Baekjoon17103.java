import java.util.*;
import java.io.*;
public class Baekjoon17103 {
    static int n;
    static boolean[] che = new boolean[1000004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 2; i <= 1000000; i++){
            if(che[i]) continue;
            for(int j = i * 2; j <= 1000000; j += i){
                che[j] = true;
            }
        }
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            int ret = 0;
            for(int j = 2; j <= a / 2; j++){
                if(!che[j] && !che[a - j]) ret++;
            }
            System.out.println(ret);
        }
    }
}