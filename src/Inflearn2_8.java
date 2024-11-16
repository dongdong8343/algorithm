import java.util.*;
import java.io.*;

public class Inflearn2_8 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[104];
        int[] ret = new int[104];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n; j++){
                if(a[j] > a[i]) cnt++;
            }
            ret[i] = cnt;
        }

        for(int i = 0; i < n; i++) System.out.print(ret[i] + " ");

        return;
    }
}