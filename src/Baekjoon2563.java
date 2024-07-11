import java.util.*;
import java.io.*;
public class Baekjoon2563 {
    static int n, cnt = 0;
    static int[][] arr = new int[104][104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int s = 0; s < n; s++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int i = a; i < a + 10; i++){
                for(int j = b; j < b+ 10; j++){
                    arr[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(arr[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}