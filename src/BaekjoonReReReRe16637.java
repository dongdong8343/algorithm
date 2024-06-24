import java.util.*;
import java.io.*;
public class BaekjoonReReReRe16637 {
    static int n, ret = -987654321;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    static int cal(int a, int b, char c){
        if(c == '+') return a + b;
        else if(c == '-') return a - b;
        else return a * b;
    }
    static void go(int here, int before){
        if(here >= op.size()){
            ret = Math.max(before, ret);
            return;
        }
        go(here + 1, cal(before, num.get(here + 1), op.get(here)));
        if(here + 2 <= num.size() - 1){
            int temp = cal(num.get(here + 1), num.get(here + 2), op.get(here + 1));
            go(here + 2, cal(before, temp, op.get(here)));
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
        go(0, num.get(0));
        System.out.println(ret);
    }
}
