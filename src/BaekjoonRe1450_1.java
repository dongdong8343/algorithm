import java.util.*;
import java.io.*;
public class BaekjoonRe1450_1 {
    static int n, c, ret = 0;
    static List<Integer> li1 = new ArrayList<>();
    static List<Integer> li2 = new ArrayList<>();
    static int[] a = new int[34];
    static void go(int s, int e, List<Integer> li, int val){
        if(val > c) return;
        if(s > e) {
            li.add(val);
            return;
        }
        go(s + 1, e, li, val + a[s]);
        go(s + 1, e, li, val);
    }
    static int find(List<Integer> li, int val){
        int l = 0, h = li.size();
        while(l < h){
            int mid = (l + h) / 2;
            if(li.get(mid) <= val) l = mid + 1;
            else h = mid;
        }
        return l;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        go(0, (n / 2) - 1, li1, 0);
        go(n / 2, n - 1, li2, 0);
        Collections.sort(li1);
        Collections.sort(li2);
        for(int x : li1){
            if(c - x >= 0){
                ret += find(li2, c - x);
            }
        }
        System.out.println(ret);
    }
}