import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon24511 {
    static int n, k;
    static Queue<Integer> t = new LinkedList<>();
    static Deque<Integer> q = new ArrayDeque<>();
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            li.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(li.get(i) == 0) q.addLast(a);
        }
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) t.add(Integer.parseInt(st.nextToken()));
        while(k-- > 0){
            int a = t.poll();
            q.addFirst(a);
            sb.append(q.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}