import java.util.*;
import java.io.*;
public class BaekjoonRe1062 {
    static int n, m;
    static int words[] = new int[54];
    static int count(int mask){
        int cnt = 0;
        for(int i = 0; i < n; i++)
            if((mask & words[i]) == words[i]) cnt++;
        return cnt;
    }
    static int go(int idx, int mask, int k){
        if(idx == 26 || k == 0) return count(mask);
        int ret = go(idx + 1, mask | (1 << idx), k - 1);
        if(idx != 'a' - 'a' && idx != 'n' - 'a' && idx != 't' - 'a' && idx != 'i' - 'a' && idx != 'c' - 'a')
            ret = Math.max(go(idx + 1, mask, k), ret);
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++)
                words[i] |= (1 << (s.charAt(j) - 'a'));
        }
        System.out.println(go(0, 0, m));
    }
}