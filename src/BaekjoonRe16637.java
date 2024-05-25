import java.util.*;
import java.io.*;
public class BaekjoonRe16637 {
    static int n, max = -987654321;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    static int cal(char c, int a, int b){
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else if(c == '*') return a * b;
        return 0;
    }
    static void solve(int here, int before){
        if(here == num.size() - 1){
            max = Math.max(max, before);
            return;
        }
        solve(here + 1, cal(op.get(here), before, num.get(here + 1)));
        if(here + 2 < num.size()){
            int temp = cal(op.get(here + 1), num.get(here + 1), num.get(here + 2));
            solve(here + 2, cal(op.get(here), before, temp));
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) num.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            else op.add(s.charAt(i));
        }
        solve(0, num.get(0));
        System.out.println(max);
    }
}
