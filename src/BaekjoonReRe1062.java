import java.util.*;
import java.io.*;
public class BaekjoonReRe1062 {
    static int n, m, ret = 0;
    static int[] words;
    static void go(int k, int mask, int idx){
        if(idx == 26 || k == 0){
            ret = Math.max(ret, count(mask));
            return;
        }
        go(k - 1, mask |(1 << idx), idx + 1);
        if('a' - 'a' != idx || 'n' - 'a' != idx || 't' - 'a' != idx || 'i' - 'a' != idx || 'c' - 'a' != idx)
            go(k, mask, idx + 1);
    }
    static int count(int mask){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if((mask & words[i]) == words[i]) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        words = new int[n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                int a = s.charAt(j) - 'a';
                words[i] |= (1 << a);
            }
        }
        go(m, 0, 0);
        System.out.println(ret);
    }
}