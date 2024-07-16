import java.util.*;
import java.io.*;
public class Baekjoon4134 {
    static int n;
    static boolean isPrime(long num){
        if(num == 0 || num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            long a = Long.parseLong(br.readLine());
            while(true){
                if(isPrime(a)) {
                    sb.append(a).append("\n");
                    break;
                }
                a++;
            }
        }
        System.out.println(sb);
    }
}