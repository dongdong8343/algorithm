import java.io.*;
import java.util.*;
public class Baekjoon1003 {
    static int[] zero = new int[44];
    static int[] one = new int[44];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        zero[0] = 1; one[1] = 1;

        for(int i = 2; i <= 40; i++){
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(zero[n] + " " + one[n] + "\n");
        }

        System.out.print(sb.toString());
    }
}