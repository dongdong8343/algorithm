import java.util.*;
import java.io.*;
public class BaekjoonRe1315_2 {
    static class Quest{
        int s, i, p;
        Quest(int s, int i, int p){
            this.s = s;
            this.i = i;
            this.p = p;
        }
    }
    static int n;
    static Quest[] quest = new Quest[54];
    static int[][] dp = new int[1004][1004];
    static int[] v = new int[54];
    static int go(int STR, int INT){
        if(dp[STR][INT] != -1) return dp[STR][INT];
        dp[STR][INT] = 0;
        int pnt = 0;
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(quest[i].i <= INT || quest[i].s <= STR){
                dp[STR][INT]++;
                if(v[i] == 0){
                    li.add(i);
                    v[i] = 1;
                    pnt += quest[i].p;
                }
            }
        }
        for(int i = 0; i <= pnt; i++){
            dp[STR][INT] = Math.max(dp[STR][INT], go(Math.min(1000, STR + i), Math.min(1000, INT + pnt - i)));
        }
        for(int i : li) v[i] = 0;
        return dp[STR][INT];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            quest[i] = new Quest(a, b, c);
        }
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(go(1, 1));
    }
}