import java.util.*;
import java.io.*;
public class Baekjoon2164 {
    static Deque<Integer> q = new LinkedList<>();
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) q.add(i);
        while(q.size() != 1){
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        System.out.println(q.peek());
    }
}