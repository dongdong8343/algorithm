import java.util.*;
import java.io.*;
public class Baekjoon11866 {
    static int n, k, idx = 0;
    static List<Integer> li = new ArrayList<>();
    static Deque<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) q.addLast(i);
        k = Integer.parseInt(st.nextToken());
        while(!q.isEmpty()){
            idx++;
            if(idx == k) {
                li.add(q.pollFirst());
                idx = 0;
                continue;
            }
            q.addLast(q.pollFirst());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < li.size(); i++){
            if(i == li.size() - 1) sb.append(li.get(i));
            else sb.append(li.get(i)).append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}