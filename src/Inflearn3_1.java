import java.util.*;
import java.io.*;

public class Inflearn3_1 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) li.add(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) li.add(Integer.parseInt(st.nextToken()));
        Collections.sort(li);
        for(int x : li) System.out.print(x + " ");
        return ;
    }
}
