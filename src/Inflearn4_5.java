import java.io.*;
import java.util.*;
public class Inflearn4_5 {
    static int n, k;
    static int[] a = new int[104];
    static TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());

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
                    ts.add(a[i] + a[j] + a[l]);
                }
            }
        }

        int cnt = 0;
        for(int x : ts){
            cnt++;
            if(cnt == k){
                System.out.println(x);
                return;
            }
        }
        System.out.println(-1);

        return ;
    }
}