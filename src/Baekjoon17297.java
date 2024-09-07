import java.util.*;
import java.io.*;
public class Baekjoon17297 {
    static final int max = 39;
    static int[] f = new int[max + 1];
    static int m;
    static String s = "Messi Gimossi";
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine()) - 1;
        f[0] = 0; f[1] = 5; f[2] = 13;
        for(int i = 3; i <= max; i++){
            f[i] = f[i - 1] + f[i - 2] + 1;
        }
        for(int i = max; i >= 2; i--){
            if(m >= f[i]) m -= f[i] + 1;
        }
        if(m == 5 || m == -1) System.out.println("Messi Messi Gimossi");
        else System.out.println(s.charAt(m));
    }
}