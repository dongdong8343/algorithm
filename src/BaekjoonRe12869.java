import java.util.*;
import java.io.*;
public class BaekjoonRe12869 {
    static class Data{
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
    static int[] hp = new int[3];
    static int[][] att = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
    };
    static int[][][] dp = new int[64][64][64];
    static int[][][] visited = new int[64][64][64];
    static int bfs(){
        visited[hp[0]][hp[1]][hp[2]] = 1;
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(hp[0], hp[1], hp[2]));
        while(!q.isEmpty()){
            Data d = q.poll();
            for(int i = 0; i < 6; i++){
                int nx = Math.max(0, d.a - att[i][0]);
                int ny = Math.max(0, d.b - att[i][1]);
                int nz = Math.max(0, d.c - att[i][2]);
                if(ny == 0 && nx == 0 && nz == 0){
                    dp[nx][ny][nz] = dp[d.a][d.b][d.c] + 1;
                    return dp[0][0][0];
                }
                if(visited[nx][ny][nz] != 0) continue;
                visited[nx][ny][nz] = 1;
                dp[nx][ny][nz] = dp[d.a][d.b][d.c] + 1;
                q.add(new Data(nx, ny, nz));
            }
        }
        return dp[0][0][0];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            hp[i] = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
}