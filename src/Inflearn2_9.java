import java.io.*;
import java.util.*;
public class Inflearn2_9 {
    static int n, sum, max = 0;
    static int[][] a = new int[54][54];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sum = 0;
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                sum += a[i][j];
            }
            max = Math.max(sum, max);
        }

        for(int j = 0; j < n; j++){
            sum = 0;
            for(int i = 0; i < n; i++){
                sum += a[i][j];
            }
            max = Math.max(sum, max);
        }
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += a[i][i];
        }
        max = Math.max(max, sum);
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += a[i][n - 1 - i];
        }
        max = Math.max(max, sum);

        System.out.println(max);

        return ;
    }
}