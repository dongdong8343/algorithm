import java.util.*;
import java.io.*;

public class Inflearn3_2 {
    static HashMap<Integer, Integer> hs = new HashMap<>();
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            hs.put(temp, hs.getOrDefault(temp, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            hs.put(temp, hs.getOrDefault(temp, 0) + 1);
        }

        for(int t : hs.keySet()){
            if(hs.get(t) == 2) li.add(t);
        }

        Collections.sort(li);

        for(int x : li) System.out.print(x + " ");

        return ;
    }
}