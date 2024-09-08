import java.util.*;
import java.io.*;
public class BaekjoonRe17297_1 {
    static int n;
    static final int MAX = 39;
    static int[] f = new int[MAX + 1];
    static String s = "Messi Gimossi";
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) - 1;
        f[1] = 5; f[2] = 13;
        for(int i = 3; i <= MAX; i++){
            f[i] = f[i - 1] + f[i - 2] + 1;
        }
        for(int i = MAX; i >= 2; i--){
            if(n >= f[i]) n -= f[i] + 1;
        }
        if(n == -1 || n== 5) System.out.println("Messi Messi Gimossi");
        else System.out.println(s.charAt(n));
    }
}