import java.util.*;
import java.io.*;
public class Baekjoon1940 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            map.put(i, Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int index = m - map.get(i);
            if(map.containsValue(index)){
                cnt++;
            }
        }
        cnt /= 2;
        System.out.println(cnt);
    }
}
