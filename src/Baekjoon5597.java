import java.util.*;
import java.io.*;
public class Baekjoon5597 {
    static int[] v = new int[40];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 28; i++){
            int n = Integer.parseInt(br.readLine());
            v[n]++;
        }
        for(int i = 1; i < 31; i++){
            if(v[i] == 0) System.out.println(i);
        }
    }
}