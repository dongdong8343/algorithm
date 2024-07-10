import java.util.*;
import java.io.*;
public class Baekjoon9086 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String s = br.readLine();
            System.out.print(s.charAt(0));
            System.out.print(s.charAt(s.length() - 1));
            System.out.println();
        }
    }
}
