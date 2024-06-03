import java.util.*;
import java.io.*;
public class BaekjoonReRe16637 {
    static int n, max = -987654321;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    static int cal(int a, int b, char c){
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else if(c == '*') return a * b;
        return 0;
    }
    static void go(int a, int idx){
        if(idx == num.size() - 1){
            max = Math.max(max, a);
            return;
        }
        go(cal(a, num.get(idx + 1), op.get(idx)), idx + 1);
        if(idx + 2 <= num.size() - 1){
            int temp = cal(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1));
            go(cal(a, temp, op.get(idx)), idx + 2);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0)
                num.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            else
                op.add(s.charAt(i));
        }
        go(num.get(0), 0);
        System.out.println(max);
        return;
    }
}