import java.util.*;
import java.io.*;

public class Inflearn4_1 {
    static int n, max = 0;
    static String s;
    static char ret;
    static HashMap<Character, Integer> hs = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        for(char c : s.toCharArray()){
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        for(char c : hs.keySet()){
            int temp = hs.get(c);
            if(max < temp) {
                max = temp;
                ret = c;
            }
        }
        System.out.println(ret);
        return ;
    }
}