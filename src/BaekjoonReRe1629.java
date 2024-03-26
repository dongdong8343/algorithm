import java.util.*;
import java.io.*;
public class BaekjoonReRe1629 {
    static long go(long a, long b, long c){
        if(b == 1)
            return a % c;
        long ret = go(a, b / 2, c);
        ret = (ret * ret) % c;
        if(b % 2 != 0)
            ret = (ret * a) % c;
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(go(a, b, c));
    }
}
