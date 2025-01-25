import java.io.*;
import java.util.*;
public class BaekjoonRe1158 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        Deque<Integer> q = new LinkedList<>();
        List<Integer> li = new ArrayList<>();

        for(int i = 1; i <= Integer.parseInt(cmd[0]); i++){
            q.addLast(i);
        }

        while(!q.isEmpty()){
            int idx = 0;
            while(idx < Integer.parseInt(cmd[1]) - 1){
                q.addLast(q.pollFirst());
                idx++;
            }
            li.add(q.pollFirst());
        }

        System.out.print("<");
        for(int i = 0; i < li.size(); i++){
            if(i == li.size() - 1) System.out.print(li.get(i));
            else System.out.print(li.get(i) + ", ");
        }
        System.out.print(">");
    }
}