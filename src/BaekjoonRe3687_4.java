import java.util.*;
import java.io.*;
public class BaekjoonRe3687_4 {
    static int tc, n;
    static String[] dp = new String[104];
    static int[] a = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static String max = "91111111111111111111111111111111111111111111111111111111";
    static String getMax(int t){
        StringBuilder sb = new StringBuilder();
        while(t > 0){
            if(t % 2 != 0){
                sb.append("7");
                t -= 3;
            }else {
                sb.append("1");
                t -= 2;
            }
        }
        return sb.toString();
    }
    static String getMin(String a, String b){
        if(a.length() == b.length()) return a.compareTo(b) < 0 ? a : b;
        return a.length() - b.length() < 0 ? a : b;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        Arrays.fill(dp, max);
        dp[0] = "";
        for(int i = 2; i < 104; i++){
            for(int j = 0; j < 10; j++){
                if(i - a[j] < 0) continue;
                if(i - a[j] == 0 && j == 0) continue;
                dp[i] = getMin(dp[i], dp[i - a[j]] + String.valueOf(j));
            }
        }
        while(tc-- > 0){
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(" ").append(getMax(n)).append('\n');
        }
        System.out.println(sb);
    }
}