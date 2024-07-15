import java.util.*;
import java.io.*;
public class Baekjoon2231 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            String s = String.valueOf(i);
            int sum = 0;
            for(int j = 0; j < s.length(); j++){
                sum += Integer.parseInt(String.valueOf(s.charAt(j)));
            }
            sum += i;
            if(sum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}