import java.util.*;
import java.io.*;
public class BaekjoonRe2910 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> ori = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            ori.add(Integer.parseInt(st.nextToken()));
            li.add(ori.get(i));
            map.put(ori.get(i), map.getOrDefault(ori.get(i), 0) + 1);
        }
        Collections.sort(ori,((o1, o2) -> {
            if(map.get(o1) == map.get(o2))
                return li.indexOf(o1) - li.indexOf(o2);
            return Integer.compare(map.get(o2), map.get(o1));
        }));

        for(int i : ori)
            System.out.print(i + " ");
    }
}
