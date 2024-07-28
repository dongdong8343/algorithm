import java.util.*;
import java.io.*;
public class BaekjoonRe1062_4 {
    static int n, k, ret = 0;
    static int[] a = new int[54];
    static void go(int idx, int cnt, int word){
        if(idx >= 26 || cnt >= k){
            int num = 0;
            for(int i = 0; i < n; i++){
                if((word & a[i]) == a[i]) num++;
            }
            ret = Math.max(ret, num);
            return;
        }
        go(idx + 1, cnt + 1, word | (1 << idx));
        if(idx + 'a' != 'a' && idx + 'a' != 'n' &&  idx + 'a' != 't' &&  idx + 'a' != 'i' &&  idx + 'a' != 'c')
            go(idx + 1, cnt, word);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                a[i] |= (1 << (s.charAt(j) - 'a'));
            }
        }
        go(0, 0, 0);
        System.out.println(ret);
    }
}