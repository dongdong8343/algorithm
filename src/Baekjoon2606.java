import java.io.*;
import java.util.*;
public class Baekjoon2606 {
    static int n, e;
    static ArrayList<Integer>[] a = new ArrayList[104];
    static boolean[] v = new boolean[104];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) a[i] = new ArrayList<>();

        for(int i = 0; i < e; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }

        System.out.println(dfs(1) - 1);
    }

    static int dfs(int now){
        int cnt = 1;
        v[now] = true;

        for(int x : a[now]){
            if(v[x]) continue;
            cnt += dfs(x);
        }
        return cnt;
    }
}