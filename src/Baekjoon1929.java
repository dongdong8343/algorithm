import java.util.*;
import java.io.*;
public class Baekjoon1929 {
    static boolean[] che = new boolean[1000004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= b; i++){
            if(che[i]) continue;
            for(int j = i * 2; j <= b; j += i){
                che[j] = true;
            }
        }
        che[1] = true;
        for(int i = a; i <= b; i++){
            if(!che[i]) System.out.println(i);
        }
    }
}