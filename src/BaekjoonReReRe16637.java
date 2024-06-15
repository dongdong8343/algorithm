import java.util.*;
import java.io.*;
public class BaekjoonReReRe16637 {
    static int n, max = -987654321;
    static List<Integer> nArr = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    static int cal(int a, int b, char c){
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else return a * b;
    }
    static void solve(int num, int idx){
        if(idx == nArr.size() - 1){
            max = Math.max(max, num);
            return;
        }
        solve(cal(num, nArr.get(idx + 1), op.get(idx)), idx + 1);
        if(idx + 1 <= op.size() - 1){
            int t = cal(nArr.get(idx + 1), nArr.get(idx + 2), op.get(idx + 1));
            solve(cal(num, t, op.get(idx)), idx + 2);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) nArr.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            else op.add(s.charAt(i));
        }
        solve(nArr.get(0), 0);
        System.out.println(max);
    }
}