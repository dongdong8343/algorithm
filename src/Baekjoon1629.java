import java.util.*;
import java.io.*;
public class Baekjoon1629 {
    static long a;
    static long b;
    static long c;
    static long go(long a, long b){
        if(b == 1) return a % c;
        long ret = go(a, b/2);
        ret = ret * ret % c;
        if(b % 2 != 0) ret = ret * a % c;
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(go(a, b));
    }
}
