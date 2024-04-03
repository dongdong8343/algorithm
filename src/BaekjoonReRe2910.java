import java.util.*;
import java.io.*;
public class BaekjoonReRe2910 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> li = new ArrayList<>();
        List<Integer> ori = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            li.add(a);
            ori.add(a);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Collections.sort(li, ((o1, o2) -> {
            if(map.get(o1) == map.get(o2))
                return ori.indexOf(o1) - ori.indexOf(o2);
            return map.get(o2) - map.get(o1);
        }));
        for(int i : li)
            System.out.print(i + " ");
    }
}
