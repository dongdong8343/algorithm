import java.util.*;
import java.io.*;
public class Baekjoon16637 {
    static int max = -987654321;
    static List<Integer> num = new ArrayList<>();
    static List<Character> oper = new ArrayList<>();
    static int cal(char c, int a, int b){
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else if(c == '*') return a * b;
        return 0;
    }
    static void go(int here, int ret){
        if(here == num.size() - 1){
            max = Math.max(max, ret);
            return;
        }
        go(here + 1, cal(oper.get(here), ret, num.get(here + 1)));
        if(here + 2 <= num.size() - 1){
            int temp = cal(oper.get(here + 1), num.get(here + 1), num.get(here + 2));
            go(here + 2, cal(oper.get(here), ret, temp));
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(i % 2 == 0)
                num.add(Integer.parseInt(String.valueOf(c)));
            else oper.add(c);
        }
        go(0, num.get(0));
        System.out.println(max);
    }
}
