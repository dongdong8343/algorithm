import java.util.*;
import java.io.*;
public class Baekjoon1940 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == m) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
