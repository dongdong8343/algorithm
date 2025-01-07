import java.util.*;
import java.io.*;

public class Inflearn5_7 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        Queue<Character> q = new LinkedList<>();

        for(char c : a.toCharArray()) q.add(c);

        for(char c : b.toCharArray()){
            if(q.contains(c)){
                if(q.poll() == c) continue;
                else break;
            }
        }

        if(q.isEmpty()) System.out.println("YES");
        else System.out.println("NO");

        return ;
    }
}
