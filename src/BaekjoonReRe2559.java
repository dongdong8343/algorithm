import java.util.*;
import java.io.*;
public class BaekjoonReRe2559 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] tem = new int[n + 4];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            tem[i] += tem[i - 1] + Integer.parseInt(st.nextToken());
        }
        int ret = -10000004;
        for(int i = 0; i <= n - k; i++){
            int temp = tem[i + k] - tem[i];
            System.out.println((i + 1) + " " + temp);
            ret = Math.max(ret, temp);
        }
        System.out.println(ret);
    }
}
