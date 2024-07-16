import java.util.*;
import java.io.*;
public class Baekjoon2485 {
    static int ret = 0, n, min = 987654321;
    static List<Integer> li = new ArrayList<>();
    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int be = Integer.parseInt(br.readLine());
        int temp = 0;
        for(int i = 1; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            min = Math.min(min, a - be);
            li.add(a - be);
            temp = gcd(temp, li.get(li.size() - 1));
            be = a;
        }
        for(int j = 0; j < li.size(); j++){
            ret += li.get(j) / temp - 1;
        }
        System.out.println(ret);
    }
}
