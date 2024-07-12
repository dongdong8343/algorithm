import java.util.*;
import java.io.*;
public class Baekjoon24265 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = n - 1; i >= 1; i--){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(2);
    }
}