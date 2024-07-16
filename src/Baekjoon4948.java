import java.util.*;
import java.io.*;
public class Baekjoon4948 {
    static boolean[] che = new boolean[300004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= 300000; i++){
            if(che[i]) continue;
            for(int j = i * 2; j <= 300000; j += i){
                che[j] = true;
            }
        }
        while(true){
            int a = Integer.parseInt(br.readLine());
            if(a == 0) break;
            int cnt = 0;
            for(int i = a + 1; i <= 2 * a; i++)
                if(!che[i]) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}