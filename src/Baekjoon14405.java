import java.util.*;
import java.io.*;
public class Baekjoon14405 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++)
            q.add(s.charAt(i));
        boolean no = false;
        while(!q.isEmpty()){
            char c = q.poll();
            if(c == 'p'){
                if(q.isEmpty() || q.poll() != 'i') no = true;
            }else if(c == 'k'){
                if(q.isEmpty() || q.poll() != 'a') no = true;
            }else if(c == 'c'){
                if(q.isEmpty() || q.poll() != 'h') no = true;
                if(q.isEmpty() || q.poll() != 'u') no = true;
            }else no = true;
            if(no) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}