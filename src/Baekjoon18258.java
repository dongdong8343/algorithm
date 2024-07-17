import java.util.*;
import java.io.*;
public class Baekjoon18258 {
    static Deque<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                int a = Integer.parseInt(st.nextToken());
                q.addLast(a);
            }else if(s.equals("front")){
                if(!q.isEmpty()) sb.append(q.peekFirst()).append("\n");
                else sb.append(-1).append("\n");
            }else if(s.equals("pop")){
                if(!q.isEmpty()) sb.append(q.pollFirst()).append("\n");
                else sb.append(-1).append("\n");
            }else if(s.equals("size")) sb.append(q.size()).append("\n");
            else if(s.equals("empty")){
                if(q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(s.equals("back")){
                if(!q.isEmpty()) sb.append(q.peekLast()).append("\n");
                else sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}