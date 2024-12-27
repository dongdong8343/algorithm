import java.util.*;
import java.io.*;

public class Inflearn4_4 {
    static HashMap<Character, Integer> k = new HashMap<>();
    static int ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        for(char c : t.toCharArray()) k.put(c, k.getOrDefault(c, 0) + 1);

        for(int i = 0; i <= s.length(); i++){
            if(i + t.length() > s.length()) break;
            String temp = s.substring(i, i + t.length());
            HashMap<Character, Integer> hs = new HashMap<>();
            for(char c : temp.toCharArray()) hs.put(c, hs.getOrDefault(c, 0) + 1);
            boolean isFail = false;
            if(hs.equals(k)) ret++;
        }

        System.out.println(ret);

        return ;
    }
}