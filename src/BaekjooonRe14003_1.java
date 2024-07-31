import java.util.*;
import java.io.*;
public class BaekjooonRe14003_1 {
    static int n, l, h;
    static int[] a = new int[1000004];
    static int[] idx = new int[1000004];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        li.add(a[0]);
        idx[0] = li.size() - 1;
        for(int i = 1; i < n; i++){
            if(li.get(li.size() - 1) < a[i]) {
                li.add(a[i]);
                idx[i] = li.size() - 1;
            }
            else{
                l = 0; h = li.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(li.get(mid) >= a[i]) h = mid;
                    else l = mid + 1;
                }
                idx[i] = h;
                li.set(h, a[i]);
            }
        }
        System.out.println(li.size());
        StringBuilder sb = new StringBuilder();
        int index = li.size() - 1;
        Stack<Integer> s = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            if(index == idx[i]) {
                index--;
                s.push(a[i]);
            }
        }
        while(!s.isEmpty())
            sb.append(s.pop()).append(' ');
        System.out.println(sb);
    }
}