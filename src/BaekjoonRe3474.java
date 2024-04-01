import java.util.*;
import java.io.*;

public class BaekjoonRe3474 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int n = Integer.parseInt(br.readLine());
            int two = 0, five = 0;
            for(int j = 2; j <= n; j *= 2)
                two += n / j;
            for(int j = 5; j <= n; j *= 5)
                five += n / j;
            int ret = Math.min(two, five);
            System.out.println(ret);
        }
    }
}
