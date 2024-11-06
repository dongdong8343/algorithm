import java.util.*;
import java.io.*;

public class Inflearn1_7 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        if(s.equals(sb.reverse().toString())){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}