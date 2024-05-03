import java.util.*;
import java.io.*;
public class Baekjoon12869 {
    static public class Data{
        int a;
        int b;
        int c;
        Data(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static int n;
    static int[][] svc = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
    };
    static int[][][] dp = new int[64][64][64];
    static int[][][] visited = new int[64][64][64];
    static Data data;
    static int solve(Data data){
        visited[data.a][data.b][data.c] = 1;
        Queue<Data> q = new LinkedList<>();
        q.add(data);
        while(!q.isEmpty()){
            Data d = q.poll();
            if(d.a == 0 && d.b == 0 && d.c == 0)
                return dp[0][0][0];
            for(int i = 0; i < 6; i++){
                int na = Math.max(0, d.a - svc[i][0]);
                int nb = Math.max(0, d.b - svc[i][1]);
                int nc = Math.max(0, d.c - svc[i][2]);
                if(visited[na][nb][nc] == 0){
                    dp[na][nb][nc] = dp[d.a][d.b][d.c] + 1;
                    visited[na][nb][nc] = 1;
                    q.add(new Data(na, nb, nc));
                }
            }
        }
        return dp[0][0][0];
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        data = new Data(arr[0], arr[1], arr[2]);
        System.out.println(solve(data));
    }
}
