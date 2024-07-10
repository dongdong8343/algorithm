import java.io.*;
import java.util.*;
public class Baekjoon3003 {
    static int[] a = new int[6];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a[0] = 1 - Integer.parseInt(st.nextToken());
        a[1] = 1 - Integer.parseInt(st.nextToken());
        a[2] = 2 - Integer.parseInt(st.nextToken());
        a[3] = 2 - Integer.parseInt(st.nextToken());
        a[4] = 2 - Integer.parseInt(st.nextToken());
        a[5] = 8 - Integer.parseInt(st.nextToken());
        for(int i = 0; i < 6; i++) System.out.print(a[i] + " ");
    }
}