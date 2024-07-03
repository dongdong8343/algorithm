import java.util.*;
import java.io.*;
class Uni1{
    int d, p;
    Uni1(int d, int p){
        this.d = d;
        this.p = p;
    }
}
public class BaekjoonRe2109 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static List<Uni1> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            li.add(new Uni1(d, p));
        }
        Collections.sort(li, (p1, p2) -> p1.d - p2.d);
        for(int i = 0; i < n; i++){
            pq.add(li.get(i).p);
            if(pq.size() > li.get(i).d) pq.poll();
        }
        int sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();
        System.out.println(sum);
    }
}