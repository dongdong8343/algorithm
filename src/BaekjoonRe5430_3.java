import java.util.*;
import java.io.*;
public class BaekjoonRe5430_3 {
    static int t, n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            String s = br.readLine();
            n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            temp = temp.substring(1, temp.length() - 1);
            Deque<Integer> dq = new ArrayDeque<>();
            if(!temp.isEmpty()){
                String[] arr = temp.split(",");
                for(int j = 0; j < arr.length; j++) dq.add(Integer.parseInt(arr[j]));
            }
            boolean error = false, reverse = false;
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == 'R') {
                    reverse = !reverse;
                }
                else if(c == 'D'){
                    if(dq.isEmpty()){
                        error = true;
                        break;
                    }
                    if(reverse) dq.removeLast();
                    else dq.removeFirst();
                }
            }
            if(error) {
                System.out.println("error");
            }
            else{
                List<Integer> li = new ArrayList<>();
                if(reverse){
                    while(!dq.isEmpty()) li.add(dq.removeLast());
                }else{
                    while(!dq.isEmpty()) li.add(dq.removeFirst());
                }
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                for(int j = 0; j < li.size(); j++){
                    sb.append(li.get(j));
                    if(j != li.size() - 1) sb.append(',');
                }
                sb.append(']');
                System.out.println(sb.toString());
            }
        }
    }
}