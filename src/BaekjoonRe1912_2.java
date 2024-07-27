import java.util.*;
import java.io.*;
public class BaekjoonRe1912_2 {
    static int n, sum = 0, ret = -1987654321;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            ret = Math.max(ret, sum);
            if(sum < 0) sum = 0;
        }
        System.out.println(ret);
    }
}