import java.util.*;
import java.io.*;

public class InflearnRe3_5 {
    static int n, sum = 1, cnt = 1, ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while(true){
            sum += ++cnt;
            if(sum > n) break;
            int temp = n - sum;
            if(temp % cnt == 0) ret++;
        }

        System.out.println(ret);

        return ;
    }
}