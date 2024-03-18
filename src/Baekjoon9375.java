import java.util.*;
import java.io.*;
public class Baekjoon9375 {
    static Map<String, Integer> map;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            map = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            long ret = 1;
            for(int j = 0; j < num; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String kind = st.nextToken();
                kind = st.nextToken();
                int cnt;
                if(map.containsKey(kind)){
                    cnt = map.get(kind);
                    cnt++;
                    map.replace(kind, cnt);
                }else{
                    cnt = 1;
                    map.put(kind, cnt);
                }
            }
            for(int n : map.values()){
                ret *= n + 1;
            }
            ret--;
            System.out.println(ret);
        }
    }
}
