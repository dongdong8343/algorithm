import java.util.*;
import java.io.*;

public class Inflearn6_2 {
    static int n;
    static int[] a = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(a[j + 1] < a[j]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++) System.out.print(a[i] + " ");

        return;
    }
}
