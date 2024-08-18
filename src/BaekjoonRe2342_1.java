import java.util.*;
import java.io.*;
public class BaekjoonRe2342_1 {
    static List<Integer> li = new ArrayList<>();
    static int n;
    static int[][][] dp = new int[100004][5][5];
    static int go(int idx, int l, int r){
        if(idx == n) return 0;
        if(dp[idx][l][r] != -1) return dp[idx][l][r];
        int left = go(idx + 1, li.get(idx), r) + power(l, li.get(idx));
        int right = go(idx + 1, l, li.get(idx)) + power(r, li.get(idx));
        dp[idx][l][r] = Math.min(left, right);
        return dp[idx][l][r];
    }
    static int power(int here, int next){
        if(here == 0) return 2;
        if(Math.abs(here - next) == 2) return 4;
        if(here == next) return 1;
        else return 3;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            li.add(x);
        }
        for(int[][] m2 : dp){
            for(int[] m1 : m2){
                Arrays.fill(m1, -1);
            }
        }
        n = li.size();
        System.out.println(go(0, 0, 0));
    }
}