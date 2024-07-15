import java.util.*;
import java.io.*;
public class Baekjoon25305 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            li.add(a);
        }
        Collections.sort(li, (o1, o2) -> {
            return o2 - o1;
        });
        System.out.println(li.get(m - 1));
    }
}