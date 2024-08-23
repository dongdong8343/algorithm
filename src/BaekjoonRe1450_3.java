import java.util.*;
import java.io.*;
public class BaekjoonRe1450_3 {
    static int n, c, ret = 0;
    static List<Integer> li1 = new ArrayList<>();
    static List<Integer> li2 = new ArrayList<>();
    static int[] a = new int[34];
    static int find(List<Integer> li, int key){
        int l = 0, h = li.size();
        while(l < h){
            int mid = (l + h) / 2;
            if(li.get(mid) <= key) l = mid + 1;
            else h = mid;
        }
        return l;
    }
    static void go(int s, int e, int v, List<Integer> li){
        if(v > c) return;
        if(s >= e) {
            li.add(v);
            return;
        }
        go(s + 1, e, v, li);
        go(s + 1, e, v + a[s], li);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        go(0, n / 2, 0, li1);
        go(n / 2, n, 0, li2);
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