import java.util.*;
import java.io.*;
public class BaekjoonRe1450_4 {
    static int n, c, ret = 0;
    static int[] a = new int[34];
    static List<Integer> li1 = new ArrayList<>();
    static List<Integer> li2 = new ArrayList<>();
    static void go(List<Integer> li, int s, int e, int sum){
        if(sum > c) return;
        if(s > e){
            li.add(sum);
            return;
        }
        go(li, s + 1, e, sum + a[s]);
        go(li, s + 1, e, sum);
    }
    static int bound(List<Integer> li, int num){
        int l = 0; int h = li.size();
        while(l < h){
            int mid = (l + h) / 2;
            if(li.get(mid) <= num) l = mid + 1;
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
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        go(li1, 0, (n / 2), 0);
        go(li2, (n / 2) + 1, n - 1, 0);
        Collections.sort(li1);
        Collections.sort(li2);
        for(int x : li1){
            ret += bound(li2, c - x);
        }
        System.out.println(ret);
    }
}