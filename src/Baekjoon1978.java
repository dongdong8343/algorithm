import java.util.*;
import java.io.*;
public class Baekjoon1978 {
    static int cnt = 0;
    static boolean[] che = new boolean[1004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        che[1] = true;
        for(int i = 2; i <= 1000; i++){
            if(che[i]) continue;
            for(int j = i * 2; j <= 1000; j += i){
                che[j] = true;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(!che[a]) cnt++;
        }
        System.out.println(cnt);
    }
}