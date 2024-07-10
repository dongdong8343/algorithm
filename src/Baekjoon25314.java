import java.util.*;
import java.io.*;
public class Baekjoon25314 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n /= 4;
        for(int i = 0; i < n; i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }
}