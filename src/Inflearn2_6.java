import java.util.*;
import java.io.*;

public class Inflearn2_6 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] a = new boolean[100004];
        a[0] = true; a[1] = true;
        for(int i = 2; i < 100001; i++){
            if(a[i]) continue;
            for(int j = i * 2; j < 100001; j += i){
                a[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder().append(st.nextToken());
            int t = Integer.parseInt(sb.reverse().toString());
            if(!a[t]) System.out.print(t + " ");
        }


        return ;
    }
}
