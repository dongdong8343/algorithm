import java.io.*;
import java.util.*;

public class Baekjoon11726 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] f = new int[n + 4];

        f[1] = 1; f[2] = 2;
        for(int i = 3; i <= n; i++){
            f[i] = (f[i - 1] + f[i - 2]) % 10007;
        }

        System.out.println(f[n]);
    }
}