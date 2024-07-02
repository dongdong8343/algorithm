import java.util.*;
import java.io.*;
class Uni{
    public int day, money;
    public Uni(int day, int money){
        this.day = day;
        this.money = money;
    }
}
public class Baekjoon2109 {
    static int n, ret = 0;
    static List<Uni> li = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int day, money;
            StringTokenizer st = new StringTokenizer(br.readLine());
            money = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());
            li.add(new Uni(day, money));
        }
        Collections.sort(li, (p1, p2) -> p1.day - p2.day);
        for(int i = 0; i < n; i++){
            pq.add(li.get(i).money);
            if(pq.size() > li.get(i).day) pq.poll();
        }
        while(!pq.isEmpty()){
            ret += pq.poll();
        }
        System.out.println(ret);
    }
}