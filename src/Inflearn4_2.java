import java.util.*;
import java.io.*;

public class Inflearn4_2 {
    static HashMap<Character, Integer> hs = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        for(char c : s1.toCharArray()){
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }

        String s2 = br.readLine();
        for(char c : s2.toCharArray()){
            if(!hs.containsKey(c) || hs.get(c) == 0) {
                System.out.println("NO");
                return;
            }
            hs.put(c, hs.get(c) - 1);
        }

        System.out.println("YES");

        return;
    }
}