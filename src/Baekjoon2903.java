import java.util.*;
import java.io.*;
public class Baekjoon2903 {
    static int n, sum = 2;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            sum += (int)Math.pow(2, i);
        }
        System.out.println(sum * sum);
    }
}