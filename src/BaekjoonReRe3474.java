import java.util.*;
import java.io.*;
public class BaekjoonReRe3474 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            int ret = 0;
            for(int j = 5; j <= x; j *= 5)
                ret += x / j;
            System.out.println(ret);
        }
    }
}
