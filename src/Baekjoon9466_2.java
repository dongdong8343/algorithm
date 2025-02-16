import java.io.*;
import java.util.*;

public class Baekjoon9466_2 {
    static int ret = 0;
    static int[] a;
    static boolean[] check;
    static boolean[] v;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());

            ret = 0;
            a = new int[n + 4];
            check = new boolean[n + 4];
            v = new boolean[n + 4];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                if(!check[i]) dfs(i);
            }

            System.out.println(n - ret);
        }
    }

    static void dfs(int now){
        v[now] = true;

        if(!v[a[now]]) dfs(a[now]);
        else {
            if(!check[a[now]]){
                ret++;
                for(int i = a[now]; i != now; i = a[i]) ret++;
            }
        }

        check[now] = true;
    }
}