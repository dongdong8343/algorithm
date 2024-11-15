import java.util.*;
import java.io.*;

public class Inflearn2_7 {
    static int n, ret = 0, cnt = 0;
    static int[] a = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            if(a[i] == 1) {
                cnt++;
                ret += cnt;
            }
            else cnt = 0;
        }

        System.out.println(ret);
        return ;
    }
}
