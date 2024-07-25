import java.util.*;
import java.io.*;
public class Baekjoon2776 {
    static int tc, n, m;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            HashMap<Integer, Integer> hs = new HashMap<>();
            List<Integer> li = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                hs.put(Integer.parseInt(st.nextToken()), 1);
            }
            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                li.add(Integer.parseInt(st.nextToken()));
            }
            for(int x : li){
                if(hs.containsKey(x)) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}