import java.util.*;
import java.io.*;
public class Baekjoon10988 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        String str1 = sb.reverse().toString();

        if(str.equals(str1))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
