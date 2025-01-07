import java.util.*;
import java.io.*;

public class Inflearn5_8 {
    public static class Person{
        int id;
        int pri;
        Person(int id, int pri){
            this.id = id;
            this.pri = pri;
        }
    }
    static Queue<Person> q = new LinkedList<>();
    static int n, k, cnt = 0, idx = 0;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int n = Integer.parseInt(st.nextToken());
            li.add(n);
            Person p = new Person(i, n);
            q.add(p);
        }

        Collections.sort(li, Collections.reverseOrder());

        while(true){
            Person p = q.poll();
            if(li.get(idx) == p.pri){
                idx++;
                cnt++;
                if(p.id == k) break;
            }else q.add(p);
        }

        System.out.println(cnt);



        return ;
    }
}
