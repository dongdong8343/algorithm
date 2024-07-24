import java.util.*;
import java.io.*;
public class Baekjoon1912 {
    static int n, ret = -1987654321, sum = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int x = Integer.parseInt(st.nextToken());
            sum += x;
            ret = Math.max(ret, sum);
            if(sum < 0) sum = 0;
        }
        System.out.println(ret);
    }
}