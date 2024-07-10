import java.util.*;
import java.io.*;
public class Baekjoon2439 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = n; i > 0; i--){
            for(int j = 1; j <= n; j++){
                if(j >= i) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}