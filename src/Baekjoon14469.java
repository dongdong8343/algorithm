import java.util.*;
import java.io.*;
class Cow{
    public int a, t;
    Cow(int a, int t){
        this.a = a;
        this.t = t;
    }
}
public class Baekjoon14469 {
    static List<Cow> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            li.add(new Cow(a, t));
        }
        Collections.sort(li, (p1, p2) -> p1.a - p2.a);
        int ret = 0;
        for(int i = 0; i < n; i++){
            if(ret > li.get(i).a) ret += li.get(i).t;
            else ret = li.get(i).a + li.get(i).t;
        }
        System.out.println(ret);
    }
}