import java.util.*;
import java.io.*;

public class Inflearn6_1 {
    static int n;
    static int[] a = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            int idx = i;
            for(int j = i + 1; j < n; j++){
                if(a[idx] > a[j]){
                    idx = j;
                }
            }
            int temp = a[i];
            a[i] = a[idx];
            a[idx] = temp;
        }

        for(int i = 0; i < n; i++) System.out.print(a[i] + " ");

        return ;
    }
}