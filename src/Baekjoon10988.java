import java.util.*;
import java.io.*;
public class Baekjoon10988 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }

        if(str.equals(sb.toString()))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
