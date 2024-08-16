import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon1450 {
    static int n, c, ret;
    static int[] a = new int[34];
    static List<Integer> li = new ArrayList<>();
    static List<Integer> li2 = new ArrayList<>();
    public static void go(int here, int num, List<Integer> t, int sum){
        if(sum > c) return;
        if(here > num){
            t.add(sum);
            return;
        }
        go(here + 1, num, t, sum + a[here]);
        go(here + 1, num, t, sum);
    }
    static int bound(List<Integer> list, int key){
        int low = 0, high = list.size();
        while(low < high){
            int mid = (low + high) / 2;
            if(list.get(mid) <= key) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        go(0, (int)n / 2 - 1, li, 0);
        go((int) n / 2, (int) n - 1, li2, 0);
        Collections.sort(li);
        Collections.sort(li2);
        for(int b : li){
            if(c - b >= 0){
                ret += bound(li2, (int)(c - b));
            }
        }
        System.out.println(ret);
    }
}