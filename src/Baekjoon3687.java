import java.util.*;
import java.io.*;
public class Baekjoon3687 {
    static int t;
    static int[] a = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static String[] dp = new String[104];
    static String MAX = "111111111111111111111111111111111111111111111111119";
    static String findMax(int here){
        StringBuilder str = new StringBuilder();
        if((here & 1) == 1) {
            str.append('7');
            here -= 3;
        }
        while(here > 0){
            str.append('1');
            here -= 2;
        }
        return str.toString();
    }
    static String getMin(String a, String b){
        if(a.length() == b.length()) return a.compareTo(b) < 0 ? a : b;
        return a.length() < b.length() ? a : b;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        Arrays.fill(dp, MAX);
        dp[0] = "";

        for(int i = 2; i < 104; i++){
            for(int j = 0; j <= 9; j++){
                if(i - a[j] < 0) continue;
                if(j == 0 && dp[i - a[j]].equals("")) continue;
                dp[i] = getMin(dp[i], dp[i - a[j]] + j);
            }
        }

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n] + " " + findMax(n));
        }
    }
}