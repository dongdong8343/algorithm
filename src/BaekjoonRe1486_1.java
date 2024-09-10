import java.util.*;
import java.io.*;
public class BaekjoonRe1486_1 {
    static int n, m, t, d, ret;
    static int[][] a = new int[30][30];
    static int[][] dp = new int[3000][3000];
    static List<Integer> v = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')
                    a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j) - 'A'));
                else
                    a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j) - 'a' + 26));
            }
        }
        ret = a[0][0];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                v.add(i * 100 + j);
            }
        }
        for(int[] row : dp){
            Arrays.fill(row, 987654321);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int d = 0; d < 4; d++){
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    int temp = Math.abs(a[i][j] - a[ny][nx]);
                    if(temp <= t){
                        if(a[i][j] < a[ny][nx]) dp[i * 100 + j][ny * 100 + nx] = temp * temp;
                        else dp[i * 100 + j][ny * 100 + nx] = 1;
                    }
                }
            }
        }

        for(int k : v){
            for(int i : v){
                for(int j : v){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for(int i : v){
            if(dp[0][i] + dp[i][0] <= d){
                ret = Math.max(ret, a[i / 100][i % 100]);
            }
        }
        System.out.println(ret);
    }
}