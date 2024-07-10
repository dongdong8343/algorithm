import java.util.*;
import java.io.*;
public class Baekjoon5622 {
    static int[] a = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
    static int sum = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sum += a[c - 'A'] + 1;
        }
        System.out.println(sum);
    }
}