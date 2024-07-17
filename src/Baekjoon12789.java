import java.util.*;
import java.io.*;
public class Baekjoon12789 {
    static int n, idx = 1;
    static Stack<Integer> s = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) q.add(Integer.parseInt(st.nextToken()));
        while(!q.isEmpty()){
            if(q.peek() == idx) {
                q.poll();
                idx++;
            }
            else if(!s.isEmpty() && s.peek() == idx){
                s.pop();
                idx++;
            }
            else s.push(q.poll());
        }
        while(!s.isEmpty()){
            if(idx == s.peek()) {
                idx++;
                s.pop();
            }
            else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}