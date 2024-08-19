import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1450_2 {
    static int n, c, ret = 0;
    static int[] a = new int[34];
    static List<Integer> li1 = new ArrayList<>();
    static List<Integer> li2 = new ArrayList<>();
    static void go(int idx, int e, List<Integer> li, int v){
        if(v > c) return;
        if(idx > e) {
            li.add(v);
            return;
        }
        go(idx + 1, e, li, v + a[idx]);
        go(idx + 1, e, li, v);
    }
    static int find(List<Integer> list, int num){
        int l = 0, h = list.size();
        while(l < h){
            int mid = (l + h) / 2;
            if(list.get(mid) <= num) l = mid + 1;
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
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        go(0, (int)n / 2 - 1, li1, 0);
        go((int)n / 2, n - 1, li2, 0);
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