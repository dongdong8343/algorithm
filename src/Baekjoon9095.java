import java.io.*;
import java.util.*;

public class Baekjoon9095 {
    static int ret = 0;
    static void go(int n, int now){
        if(now == n){
            ret++;
            return;
        }else if(now > n) return;
        go(n, now + 1);
        go(n, now + 2);
        go(n, now + 3);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            ret = 0;
            go(n, 0);
            System.out.println(ret);
        }
    }
}