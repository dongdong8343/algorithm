import java.io.*;
import java.util.*;
public class Inflearn1_5 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) sb.append(c);
        }

        String temp = String.valueOf(sb.reverse());
        sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) sb.append(temp.charAt(idx++));
            else sb.append(c);
        }

        System.out.println(sb.toString());

        return ;
    }
}
