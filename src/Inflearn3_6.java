import java.util.*;
import java.io.*;

public class Inflearn3_6 {
    static int n, k, cnt = 0, ret = 0, lt = 0;
    static int[] a = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            if(a[i] == 0) cnt++;
            if(cnt > k){
                while(true){
                    if(a[lt++] == 0) {
                        cnt--;
                        break;
                    }
                }
            }
            ret = Math.max(ret, i - lt + 1);
        }

        System.out.println(ret);


        return ;
    }
}
