import java.util.*;
import java.io.*;
public class Baekjoon5086 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a + b == 0) break;
            if(a > b){
                if(a % b == 0) System.out.println("multiple");
                else System.out.println("neither");
            }else{
                if(b % a == 0) System.out.println("factor");
                else System.out.println("neither");
            }
        }
    }
}