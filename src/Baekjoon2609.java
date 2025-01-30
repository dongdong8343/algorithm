import java.io.*;
import java.util.*;
public class Baekjoon2609 {
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cmd = br.readLine().split(" ");
        int a = Integer.parseInt(cmd[0]);
        int b = Integer.parseInt(cmd[1]);

        int num = gcd(a, b);
        System.out.println(num);
        System.out.println(a * b / num);
    }
}
