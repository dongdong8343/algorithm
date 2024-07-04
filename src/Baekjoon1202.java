import java.util.*;
import java.io.*;
class Ju{
    public int m, v;
    Ju(int m, int v){
        this.m = m;
        this.v = v;
    }
}
public class Baekjoon1202 {
    static long n, k, ret = 0;
    static int idx = 0;
    static List<Ju> li = new ArrayList<>();
    static List<Integer> bags = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            li.add(new Ju(m, v));
        }
        bags.add(0);
        for(int i = 0; i < k; i++) bags.add(Integer.parseInt(br.readLine()));
        li.sort((o1, o2) -> o2.m - o1.m);
        bags.sort((o1, o2) -> o2- o1);
        for(int i = 0; i < n; i++){
            if(bags.get(idx) >= li.get(i).m) {
                pq.add(li.get(i).v);
            }
            if(idx + 1 < k && bags.get(idx + 1) >= li.get(i).m) idx++;
            if(pq.size() > idx + 1) pq.poll();

        }
        while(!pq.isEmpty()) ret += pq.poll();
        System.out.println(ret);
    }
}