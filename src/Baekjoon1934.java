import java.util.*;
import java.io.*;
public class Baekjoon1934 {
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = Math.max(a, b);
            int i = 2;
            int temp = max;
            while(true){
                if(temp % a == 0 && temp % b == 0) {
                    System.out.println(temp);
                    break;
                }
                temp = max * i++;
            }
        }
    }
}