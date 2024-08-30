import java.util.*;
import java.io.*;
public class BaekjoonRe3687_2 {
    static int tc;
    static String[] dp = new String[104];
    static String max = "111111111111111111111111111111111111111111111111119";
    static int[] a = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static String getMin(String a, String b){
        if(a.length() == b.length()) return a.compareTo(b) < 0 ? a : b;
        return a.length() < b.length() ? a : b;
    }
    static String getMax(int n){
        StringBuilder sb = new StringBuilder();
        if(n % 2 != 0) {
            sb.append("7");
            n -= 3;
        }
        while(n != 0){
            sb.append("1");
            n -= 2;
        }
        return sb.toString();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        Arrays.fill(dp, max);
        dp[0] = "";
        for(int i = 2; i < 104; i++){
            for(int j = 0; j <= 9; j++){
                if(i - a[j] < 0) continue;
                if(j == 0 && dp[i - a[j]].equals("")) continue;
                dp[i] = getMin(dp[i], dp[i - a[j]] + j);
            }
        }
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n] + " " + getMax(n));
        }
    }
}