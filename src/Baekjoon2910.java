import java.io.*;
import java.util.*;
public class Baekjoon2910 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> li = new ArrayList<>();
        List<Integer> original = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            li.add(Integer.parseInt(st.nextToken()));
            original.add(li.get(i));
            map.put(li.get(i), map.getOrDefault(li.get(i), 0) + 1);
        }

        Collections.sort(li, (o1, o2) -> {
            if(map.get(o1) == map.get(o2))
                return original.indexOf(o1) - original.indexOf(o2);
            else
                return Integer.compare(map.get(o2), map.get(o1));
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(li.get(i) + " ");
        System.out.println(sb);
    }
}