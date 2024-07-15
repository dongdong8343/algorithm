import java.util.*;
import java.io.*;
public class Baekjoon10989 {
    static int n;
    static int[] a = new int[10004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            a[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10001; i++){
            while(a[i] != 0) {
                sb.append(i + "\n");
                a[i]--;
            }
        }
        System.out.println(sb);
    }
}