import java.util.*;
import java.io.*;
public class BaekjoonRe1620 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map1 = new HashMap<>();

        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            map.put(name, i);
            map1.put(i, name);
        }
        for(int i = 0; i < m; i++){
            String quiz = br.readLine();
            if(map.containsKey(quiz))
                System.out.println(map.get(quiz));
            else{
                int num = Integer.parseInt(quiz);
                System.out.println(map1.get(num));
            }
        }
    }
}
