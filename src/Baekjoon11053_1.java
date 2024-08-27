import java.util.*;
import java.io.*;
public class Baekjoon11053_1 {
    static int n;
    static int[] a = new int[1004];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            if(li.isEmpty() || li.get(li.size() - 1) < a[i]) li.add(a[i]);
            else{
                int l = 0, h = li.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(li.get(mid) >= a[i]) h =mid;
                    else l = mid + 1;
                }
                li.set(h, a[i]);
            }
        }
        System.out.println(li.size());
    }
}