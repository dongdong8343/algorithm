import java.util.*;
import java.io.*;

public class InflearnRe2_8 {
    static int n;
    static int[] a = new int[104];
    static int[] ret = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n; j++){
                if(a[i] < a[j]) cnt++;
            }
            ret[i] = cnt;
        }

        for(int i = 0; i < n; i++){
            System.out.print(ret[i] + " ");
        }

        return ;
    }
}