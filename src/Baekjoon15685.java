import java.util.*;
import java.io.*;
public class Baekjoon15685 {
    static int n, ret = 0;
    static int[][] a = new int[104][104];
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int s = 0; s < n; s++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            List<Integer> li = new ArrayList<>();
            li.add(d);
            a[y][x] = 1;
            int ny = y + dy[d];
            int nx = x + dx[d];
            a[ny][nx] = 1;
            y = ny; x = nx;
            for(int i = 1; i <= g; i++){
                int len = li.size() - 1;
                for(int j = len; j >= 0; j--){
                    int dd = li.get(j);
                    dd++;
                    if(dd > 3) dd = 0;
                    ny = y + dy[dd];
                    nx = x + dx[dd];
                    a[ny][nx] = 1;
                    li.add(dd);
                    y = ny;
                    x = nx;
                }
            }
        }
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(a[i][j] == 1){
                    if(a[i][j + 1] == 1 && a[i + 1][j + 1] == 1 && a[i + 1][j] == 1) ret++;
                }
            }
        }
        System.out.println(ret);
    }
}