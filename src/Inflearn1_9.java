import java.io.*;
import java.util.*;
public class Inflearn1_9 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = "";

        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)) t += c;
        }

        System.out.println(Integer.parseInt(t));

        return ;
    }
}
