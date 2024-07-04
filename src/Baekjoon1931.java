import java.util.*;
import java.io.*;
class Room{
    public int s, e;
    Room(int s, int e){
        this.s = s;
        this.e = e;
    }
}
public class Baekjoon1931 {
    static int n, ret = 0, to;
    static List<Room> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            li.add(new Room(s, e));
        }
        Collections.sort(li, (p1, p2) -> {
            if(p1.e == p2.e) return p1.s - p2.s;
            return p1.e - p2.e;
        });
        to = li.get(0).e;
        ret = 1;
        for(int i = 1; i < n; i++){
            if(li.get(i).s < to) continue;
            to = li.get(i).e;
            ret++;
        }
        System.out.println(ret);
    }
}