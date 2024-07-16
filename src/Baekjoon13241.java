import java.util.*;
import java.io.*;
public class Baekjoon13241 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long max = Math.max(a, b);
        long idx = 2;
        long t = max;
        while(true){
           if(t % a == 0 && t % b == 0) {
               System.out.println(t);
               break;
           }
           t = max * idx++;
        }
    }
}