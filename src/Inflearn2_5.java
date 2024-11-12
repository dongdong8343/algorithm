import java.util.*;
import java.io.*;

public class Inflearn2_5 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] a = new boolean[200004];
        int cnt = 0;

        a[0] = true; a[1] = true;

        for(int i = 2; i <= 200000; i++){
            if(a[i]) continue;
            for(int j = 2 * i; j <= 200000; j += i){
                a[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            if(!a[i]) cnt++;
        }

        System.out.println(cnt);

        return;
    }
}
