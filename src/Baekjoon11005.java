import java.util.*;
import java.io.*;
public class Baekjoon11005 {
    static int n, b;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int a = n % b;
            n /= b;
            if(a > 9){
                sb.append(Character.toChars('A' + (a - 10)));
            }else{
                sb.append(a);
            }
        }
        sb.reverse();
        System.out.println(sb);
    }
}