import java.util.*;
import java.io.*;
public class Baekjoon11478 {
    static String s;
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            hs.add(sb.toString());
            for(int j = i + 1; j < s.length(); j++){
                sb.append(s.charAt(j));
                hs.add(sb.toString());
            }
        }
        System.out.println(hs.size());
    }
}