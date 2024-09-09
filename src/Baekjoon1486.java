import java.util.*;
import java.io.*;
public class Baekjoon1486 {
    static int n, m, t, d, INF = 987654321, ret;
    static int[][] a = new int[30][30];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<Integer> v = new ArrayList<>();
    static int[][] b = new int[3000][3000];
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
                if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') a[i][j] = s.charAt(j) - 'A';
                else a[i][j] = s.charAt(j) - 'a' + 26;
            }
        }
        ret = a[0][0];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                v.add(i * 100 + j);
            }
        }
        for(int[] row : b){
            Arrays.fill(row, INF);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int d = 0; d < 4; d++){
                    int ny = i + dy[d];
                    int nx = j + dx[d];

                    if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                    int h = Math.abs(a[i][j] - a[ny][nx]);

                    if(h <= t){
                        if(a[ny][nx] > a[i][j]) b[i * 100 + j][ny * 100 + nx] = h * h;
                        else b[i * 100 + j][ny * 100 + nx] = 1;
                    }
                }
            }
        }

        for(int k : v){
            for(int i : v){
                for(int j : v){
                    b[i][j] = Math.min(b[i][j], b[i][k] + b[k][j]);
                }
            }
        }

        for(int i : v){
            if(d >= b[0][i] + b[i][0]){
                ret = Math.max(ret, a[i / 100][i % 100]);
            }
        }

        System.out.println(ret);
    }
}