import java.util.*;
import java.io.*;
public class BaekjoonRe5430_4 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String s = br.readLine();
            Queue<Character> q = new LinkedList<>();
            for(int i = 0; i < s.length(); i++) q.add(s.charAt(i));
            int n = Integer.parseInt(br.readLine());
            s = br.readLine();
            s = s.substring(1, s.length() - 1);
            Deque<Integer> dq = new ArrayDeque<>();
            if(!s.isEmpty()) {
                String[] nums = s.split(",");
                for(String x : nums) dq.add(Integer.parseInt(x));
            }
            boolean error = false, rev = false;
            while(!q.isEmpty()){
                char c = q.poll();
                if(c == 'R') rev = !rev;
                else{
                    if(dq.isEmpty()){
                        error = true;
                        break;
                    }
                    if(rev) dq.pollLast();
                    else dq.pollFirst();
                }
            }
            if(error) {
                System.out.println("error");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if(rev){
                while(!dq.isEmpty()){
                    if(dq.size() > 1) sb.append(dq.pollLast()).append(',');
                    else sb.append(dq.pollLast());
                }
            }
            else{
                while(!dq.isEmpty()){
                    if(dq.size() > 1) sb.append(dq.pollFirst()).append(',');
                    else sb.append(dq.pollFirst());
                }
            }
            sb.append(']');
            System.out.println(sb);
        }
    }
}