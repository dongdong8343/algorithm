import java.util.*;
import java.io.*;
public class Baekjoon1427 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) li.add(s.charAt(i) - '0');
        Collections.sort(li, Collections.reverseOrder());
        for(int x : li) sb.append(x);
        System.out.println(sb);
    }
}