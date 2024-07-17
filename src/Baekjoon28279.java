import java.util.*;
import java.io.*;
public class Baekjoon28279 {
    static int n;
    static Deque<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                q.addFirst(b);
            }else if(a == 2){
                int b = Integer.parseInt(st.nextToken());
                q.addLast(b);
            }else if(a == 3){
                if(!q.isEmpty()) sb.append(q.pollFirst()).append("\n");
                else sb.append(-1).append("\n");
            }else if(a == 4){
                if(!q.isEmpty()) sb.append(q.pollLast()).append("\n");
                else sb.append(-1).append("\n");
            }else if(a == 5){
                sb.append(q.size()).append("\n");
            }else if(a == 6){
                if(q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(a == 7){
                if(!q.isEmpty()) sb.append(q.peekFirst()).append("\n");
                else sb.append(-1).append("\n");
            }else if(a == 8){
                if(!q.isEmpty()) sb.append(q.peekLast()).append("\n");
                else sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}