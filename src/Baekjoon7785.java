import java.util.*;
import java.io.*;
public class Baekjoon7785 {
    static int n;
    static HashMap<String, Integer> hs = new HashMap<>();
    static List<String> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String e = st.nextToken();
            if(e.equals("enter")) hs.put(s, 1);
            else hs.remove(s);
        }
        for(String s : hs.keySet()){
            li.add(s);
        }
        Collections.sort(li, (o1, o2) -> {
            int size = Math.min(o1.length(), o2.length());
            for(int i = 0; i < size; i++){
                if(o1.charAt(i) != o2.charAt(i)) return o2.charAt(i) - o1.charAt(i);
            }
            return o2.length() - o1.length();
        });
        StringBuilder sb = new StringBuilder();
        for(String s : li) sb.append(s).append("\n");
        System.out.println(sb);
    }
}