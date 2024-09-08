import java.util.*;
import java.io.*;
public class Baekjoon3653 {
    static int tc, n, m, u_idx = 100001;
    static int[] tree = new int[200004];
    static Map<Integer, Integer> map = new HashMap<>();
    static void update(int idx, int val){
        while(idx < 200004){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }
    static int sum(int idx){
        int ret = 0;
        while(idx > 0){
            ret += tree[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            tree = new int[200004];
            map.clear();
            u_idx = 100001;
            for(int i = 1; i <= n; i++){
                update(i + u_idx, 1);
                map.put(i, i + u_idx);
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                int val = Integer.parseInt(st.nextToken());
                int x = map.get(val);
                sb.append(sum(x) - 1).append(" ");
                update(x, -1);
                update(--u_idx, 1);
                map.put(val, u_idx);
            }
            System.out.println(sb);
        }
    }
}