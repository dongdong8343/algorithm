import java.util.*;
import java.io.*;
public class BaekjoonRe1062_3 {
    static int n, k, max = 0;
    static int[] a = new int[54];
    static void go(int idx, int mask, int cnt){
        if(cnt >= k || idx >= 26){
            int temp = 0;
            for(int i = 0; i < n; i++){
                if((a[i] & mask)== a[i]) temp++;
            }
            max = Math.max(max, temp);
            return;
        }
        if('a' + idx != 'a' && 'a' + idx != 'n' && 'a' + idx != 't' && 'a' + idx != 'i' && 'a' + idx != 'c')
            go(idx + 1, mask, cnt);
        go(idx + 1, mask |= (1 << idx), cnt + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                a[i] |= (1 << (s.charAt(j) - 'a'));
            }
        }
        go(0, 0, 0);
        System.out.println(max);
    }
}