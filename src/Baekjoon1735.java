import java.util.*;
import java.io.*;
public class Baekjoon1735 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int t1 = b1 * b2;
        int t2 = a1 * b2 + a2 * b1;
        int max = Math.max(t1, t2);
        int temp = 0;
        for(int i = 1; i <= max; i++){
            if(t1 % i == 0 && t2 % i == 0) temp = i;
        }
        System.out.println((t2 / temp) + " " + (t1 / temp));
    }
}