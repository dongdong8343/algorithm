import java.util.*;
import java.io.*;
public class Baekjoon10988_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if(s.equals(sb.toString())) System.out.println(1);
        else System.out.println(0);
    }
}