import java.util.*;
import java.io.*;
public class BaekjoonRe3687_1 {
    static String getMax(int n){
        StringBuilder sb = new StringBuilder();
        if((n & 1) == 1){
            sb.append('7');
            n -= 3;
        }
        while(n > 0) {
            sb.append('1');
            n -= 2;
        }
        return sb.toString();
    }
    static String compare(String a, String b){
        if(a.length() == b.length()){
            if(a.compareTo(b) < 0) return a;
            return b;
        }
        if(a.length() < b.length()) return a;
        return b;
    }
    static void getMin(int n){
        dp[0] = "";
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                if(i - cnt[j] < 0) continue;
                if(j == 0 && dp[i - cnt[j]].equals("")) continue;
                dp[i] = compare(dp[i], dp[i - cnt[j]] + j);
            }
        }
    }
    static String[] dp = new String[104];
    static int[] cnt = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static String Max = "111111111111111111111111111111111111111111111111119";
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Arrays.fill(dp, Max);
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            getMin(n);
            System.out.println(dp[n] + " " + getMax(n));
        }
    }
}