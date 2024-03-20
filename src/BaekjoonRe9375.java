import java.io.*;
import java.util.*;
public class BaekjoonRe9375 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                name = st.nextToken();
                if(map.containsKey(name)){
                    int cnt = map.get(name);
                    cnt++;
                    map.replace(name, cnt);
                }else{
                    map.put(name, 1);
                }
            }
            int ret = 1;
            for(int num : map.values()){
                ret *= num + 1;
            }
            ret--;
            System.out.println(ret);
        }
    }
}
