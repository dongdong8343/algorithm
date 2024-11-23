import java.util.*;
import java.io.*;

public class Inflearn3_5 {
    static int n, cnt = 0, sum = 0, p1 = 1, p2 = 1;
    static int[] a = new int[1004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 1000; i++) a[i] = i;

        while(p1 <= 1000){
            if(sum < n) sum += a[p1++];
            else sum -= a[p2++];
            if(sum == n) cnt++;
        }

        System.out.println(--cnt);

        return ;
    }
}