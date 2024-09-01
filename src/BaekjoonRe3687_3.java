import java.util.*;
import java.io.*;
public class BaekjoonRe3687_3 {
    static int tc;
    static String max = "111111111111111111111111111111111111111111111111111117";
    static String[] dp = new String[104];
    static int[] a = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static String getMin(String s1, String s2){
        if(s1.length() == s2.length())
            return s1.compareTo(s2) < 0 ? s1 : s2;
        return s1.length() - s2.length() < 0 ? s1 : s2;
    }
    static String getMax(int n){
        StringBuilder sb = new StringBuilder();
        if(n % 2 != 0) {
            sb.append("7");
            n -= 3;
        }
        while(n > 0){
            n -= 2;
            sb.append("1");
        }
        return sb.toString();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        Arrays.fill(dp, max);
        dp[0] = "";
        for(int i = 2; i <= 100; i++){
            for(int j = 0; j < 10; j++){
                if(i - a[j] < 0) {
                    continue;
                }
                if(dp[i - a[j]].equals("") && j == 0) {
                    continue;
                }
                dp[i] = getMin(dp[i], dp[i - a[j]] + j);
            }
        }
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n] + " " + getMax(n));
        }
    }
}