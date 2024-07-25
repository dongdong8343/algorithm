import java.util.*;
import java.io.*;
public class Baekjoon7795 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int ret = 0, idx = -1;
            st = new StringTokenizer(br.readLine());
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for(int i = 0; i < n; i++) a.add(Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) b.add(Integer.parseInt(st.nextToken()));
            Collections.sort(a);
            Collections.sort(b);
            for(int i = 0; i < n; i++){
                int l = 0, h = m - 1;
                while(l <= h){
                    int mid = (l + h) / 2;
                    if(b.get(mid) < a.get(i)) {
                        l = mid + 1;
                        idx = mid;
                    }else h = mid - 1;
                }
                if(idx != -1) ret += (m - (m - idx)) + 1;
            }
            System.out.println(ret);
        }
    }
}