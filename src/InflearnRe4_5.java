import java.util.*;
import java.io.*;

public class InflearnRe4_5 {
    static int n, k, sum = 0, cnt = 0;
    static int[] a = new int[104];
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int l = j + 1; l < n; l++){
                    sum = a[i] + a[j] + a[l];
                    hs.add(sum);
                }
            }
        }

        ArrayList<Integer> li = new ArrayList<>(hs);
        Collections.sort(li, Collections.reverseOrder());

        for(int x : li){
            cnt++;
            if(cnt == k) {
                System.out.println(x);
                return;
            }
        }
        System.out.println(-1);
        return;
    }
}
