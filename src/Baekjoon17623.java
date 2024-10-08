import java.util.*;
import java.io.*;
public class Baekjoon17623 {
    static int tc;
    static final String Max = "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]";
    static String[] dp = new String[1004];
    static HashMap<Character, Integer> hs = new HashMap<>();
    static String getMin(String a, String b){
        int x = a.length();
        int y = b.length();
        if(x != y) return x - y < 0 ? a : b;
        for(int i = 0; i < x; i++){
            if(a.charAt(i) == b.charAt(i)) continue;
            if(hs.get(a.charAt(i)) < hs.get(b.charAt(i))) return a;
            else return b;
        }
        return a;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        Arrays.fill(dp, Max);

        hs.put('(', 1); hs.put(')', 2);
        hs.put('{', 3); hs.put('}', 4);
        hs.put('[', 5); hs.put(']', 6);

        dp[1] = "()"; dp[2] = "{}"; dp[3] = "[]";
        for(int i = 4; i <= 1000; i++){
            if(i % 2 == 0) dp[i] = getMin(dp[i], '(' + dp[i / 2] + ')');
            if(i % 3 == 0) dp[i] = getMin(dp[i], '{' + dp[i / 3] + '}');
            if(i % 5 == 0) dp[i] = getMin(dp[i], '[' + dp[i / 5] + ']');
            for(int j = 1; j < i; j++) dp[i] = getMin(dp[i], dp[j] + dp[i - j]);
        }
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}