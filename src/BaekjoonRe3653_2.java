import java.util.*;
import java.io.*;
public class BaekjoonRe3653_2 {
    static int tc, n, m, idx = 100001;
    static int[] tree = new int[200004];
    static HashMap<Integer, Integer> hs = new HashMap<>();
    static void update(int here, int v){
        while(here < 200004){
            tree[here] += v;
            here += (here & -here);
        }
    }
    static int sum(int here){
        int ret = 0;
        while(here > 0){
            ret += tree[here];
            here -= (here & -here);
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            tree = new int[200004];
            idx = 100001;
            hs.clear();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for(int i = 1; i <= n; i++){
                int here = i + idx;
                update(here, 1);
                hs.put(i, here);
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                int x = Integer.parseInt(st.nextToken());
                int here = hs.get(x);
                sb.append(sum(here - 1)).append(" ");
                update(here, -1);
                hs.put(x, --idx);
                update(idx, 1);
            }
            System.out.println(sb);
        }
    }
}