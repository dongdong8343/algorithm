import java.io.*;
import java.util.*;

public class Baekjoon1260 {
    static int n, m, v;
    static int[][] a = new int[1004][1004];
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        n = Integer.parseInt(cmd[0]);
        m = Integer.parseInt(cmd[1]);
        v = Integer.parseInt(cmd[2]);

        for (int i = 0; i < m; i++) {
            String[] st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int e = Integer.parseInt(st[1]);
            a[s][e] = 1;
            a[e][s] = 1;
        }

        visited = new boolean[1004];
        dfs(v);
        sb.append("\n");

        visited = new boolean[1004];
        bfs(v);

        System.out.println(sb.toString());
    }

    public static void dfs(int s) {
        visited[s] = true;
        sb.append(s + " ");
        for(int i = 1; i <= n; i++){
            if(a[s][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            sb.append(x + " ");
            for(int i = 1; i <= n; i++){
                if(a[x][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}