import java.util.*;
import java.io.*;
public class Baekjoon9063 {
    static List<Integer> li1 = new ArrayList<>();
    static List<Integer> li2 = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li1.add(x);
            li2.add(y);
        }
        Collections.sort(li1);
        Collections.sort(li2);
        int mx = Math.abs(li1.get(li1.size()- 1) - li1.get(0));
        int my = Math.abs(li2.get(li2.size()- 1) - li2.get(0));
        if(n == 1) System.out.println(0);
        else System.out.println(mx * my);
    }
}