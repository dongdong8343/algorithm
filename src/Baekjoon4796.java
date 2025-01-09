import java.io.*;
import java.util.*;
public class Baekjoon4796 {
    static int i = 0, l, p, v;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            i++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if(l == 0 && p == 0 && v == 0) break;
            System.out.print("Case " + i + ": ");
            System.out.println(v / p * l + Math.min(v % p, l));
        }
    }
}