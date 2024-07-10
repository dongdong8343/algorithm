import java.util.*;
import java.io.*;
public class Baekjoon25304 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            sum += (a * b);
        }
        if(sum == x) System.out.println("Yes");
        else System.out.println("No");
    }
}