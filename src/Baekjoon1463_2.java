import java.io.*;
import java.util.*;

public class Baekjoon1463_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[1000004];
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) a[i] = 987654321;
        a[1] = 0;

        for(int i = 1; i <= n; i++){
            int temp = a[i] + 1;
            if(i * 3 <= 1000000 && a[i * 3] > temp) a[i * 3] = temp;
            if(i * 2 <= 1000000 && a[i * 2] > temp) a[i * 2] = temp;
            if(i + 1 <= 1000000 && a[i + 1] > temp) a[i + 1] = temp;
        }

        System.out.println(a[n]);
    }
}
