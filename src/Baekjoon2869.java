import java.util.*;
import java.io.*;
public class Baekjoon2869 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int t = (v - a) / (a - b);
        if((a - b) * t + a >= v) System.out.println(t + 1);
        else System.out.println(t + 2);
    }
}