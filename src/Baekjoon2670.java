import java.util.*;
import java.io.*;
public class Baekjoon2670 {
    static int n;
    static double[] a = new double[100004];
    static double ret;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Double.parseDouble(br.readLine());
        }
        for(int i = 0; i < n; i++){
            double x = 1;
            for(int j = i; j < n; j++){
                x *= a[j];
                ret = Math.max(x, ret);
            }
        }
        System.out.printf("%.3f", ret);
    }
}