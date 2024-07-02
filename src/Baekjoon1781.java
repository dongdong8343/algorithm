import java.util.*;
import java.io.*;
class Cup{
    public int d, a;
    Cup(int d, int a){
        this.d = d;
        this.a = a;
    }
}
public class Baekjoon1781 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static List<Cup> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            li.add(new Cup(d, a));
        }
        Collections.sort(li, (p1, p2) -> p1.d - p2.d);
        for(int i = 0; i < n; i++){
            pq.add(li.get(i).a);
            if(pq.size() > li.get(i).d) pq.poll();
        }
        int sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();
        System.out.println(sum);
    }
}