import java.io.*;
import java.util.*;
public class Baekjoon3474 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int n = Integer.parseInt(br.readLine());
            int ret2 = 0, ret5 = 0;
            for(int j = 2; j <= n; j *= 2)
                ret2 += n / j;
            for(int j = 5; j <= n; j *= 5)
                ret5 += n / j;
            System.out.println(Math.min(ret2, ret5));
        }
    }
}
