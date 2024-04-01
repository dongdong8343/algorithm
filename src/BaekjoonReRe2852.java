import java.util.*;
import java.io.*;
public class BaekjoonReRe2852 {
    static int prev;
    static int go(int sum, int time){
        sum += time - prev;
        return sum;
    }
    static void print(int sum){
        int m = sum / 60;
        int s = sum % 60;
        String sm = "00" + String.valueOf(m);
        sm = sm.substring(sm.length() - 2);
        String ss = "00" + String.valueOf(s);
        ss = ss.substring(ss.length() - 2);
        System.out.println(sm + ":" + ss);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0, asum = 0, bsum = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int min = Integer.parseInt(s.substring(0, 2));
            int sec = Integer.parseInt(s.substring(3));
            int cur = min * 60 + sec;
            if(a > b)
                asum = go(asum, cur);
            if(b > a)
                bsum = go(bsum, cur);
            if(t == 1)
                a++;
            else
                b++;
            prev = cur;
        }
        if(a > b)
            asum = go(asum, 48 * 60);
        if(b > a)
            bsum = go(bsum, 48 * 60);
        print(asum);
        print(bsum);
    }
}
