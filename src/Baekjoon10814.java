import java.util.*;
import java.io.*;
public class Baekjoon10814 {
    static class Member{
        int y;
        String s;
        int a;
        Member(int y, String s, int a){
            this.y = y;
            this.s = s;
            this.a = a;
        }
    }
    static int n;
    static List<Member> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            li.add(new Member(y, s, i));
        }
        Collections.sort(li, (o1, o2) -> {
            if(o1.y == o2.y) return o1.a - o2.a;
            return o1.y - o2.y;
        });
        for(Member m : li) System.out.println(m.y + " " + m.s);
    }
}