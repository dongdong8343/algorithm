import java.io.*;
import java.util.*;

public class Baekjoon9466 {
    static boolean[] check;
    static boolean[] v;
    static int[] a;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();
    static int ret;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            int n = Integer.parseInt(br.readLine());

            v = new boolean[n + 4];
            check = new boolean[n + 4];
            a = new int[n + 4];
            ret = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j <= n; j++){
                if(!check[j]) dfs(j);
            }

            sb.append(n - ret).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int now){
        if(v[now]) return;
        v[now] = true;

        int next = a[now];

        if(!v[next]) dfs(next);
        else{
            if(!check[next]) {
                ret++;
                for(int i = next; i != now; i = a[i]) ret++;
            }
        }

        check[now] = true;
    }
}