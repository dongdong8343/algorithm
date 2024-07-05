import java.util.*;
import java.io.*;
public class Baekjoon3273 {
    static int n, x, l, h, sum;
    static long ret = 0;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) li.add(Integer.parseInt(st.nextToken()));
        Collections.sort(li);
        l = 0;
        h = n - 1;
        while(true){
            int sum = li.get(l) + li.get(h);
            if(sum == x) ret++;
            if(sum >= x) h--;
            else l++;
            if(l == h || h < 0 || l >= n) break;
        }
        System.out.println(ret);
    }
}