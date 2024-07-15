import java.util.*;
import java.io.*;
public class Baekjoon18870 {
    static int n, idx = 0;
    static List<Integer> li = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static HashMap<Integer, Integer> h = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            li.add(a);
            temp.add(a);
        }
        Collections.sort(li);
        for(int x : li) {
            if(h.containsKey(x)) continue;
            h.put(x, idx);
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int a = temp.get(i);
            int b = h.get(a);
            sb.append(b).append(" ");
        }
        System.out.println(sb);
    }
}