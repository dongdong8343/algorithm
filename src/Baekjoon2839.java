import java.util.*;
import java.io.*;
public class Baekjoon2839 {
    static int n, ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(true){
            if(n % 5 == 0){
                ret += n / 5;
                System.out.println(ret);
                break;
            }
            else{
                n -= 3;
                ret ++;
            }
            if(n < 0){
                System.out.println(-1);
                return;
            }
        }
    }
}