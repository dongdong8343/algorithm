import java.util.*;
import java.io.*;
public class Baekjoon1764 {
    static HashMap<String, Integer> hs1 = new HashMap<>();
    static HashMap<String, Integer> hs2 = new HashMap<>();
    static List<String> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            hs1.put(s, 1);
        }
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            hs2.put(s, 1);
        }
        for(String s : hs1.keySet()){
            if(hs2.containsKey(s)) li.add(s);
        }
        Collections.sort(li, (o1, o2) -> {
            int size = Math.min(o1.length(), o2.length());
            for(int i = 0; i < size; i++){
                if(o1.charAt(i) != o2.charAt(i)) return o1.charAt(i) - o2.charAt(i);
            }
            return o1.length() - o2.length();
        });
        StringBuilder sb = new StringBuilder();
        sb.append(li.size()).append("\n");
        for(String s : li) sb.append(s).append("\n");
        System.out.println(sb);
    }
}