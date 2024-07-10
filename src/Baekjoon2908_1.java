import java.util.*;
import java.io.*;
public class Baekjoon2908_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());
        sb1.reverse();
        sb2.reverse();
        int a = Integer.parseInt(sb1.toString());
        int b = Integer.parseInt(sb2.toString());
        System.out.println(Math.max(a, b));
    }
}