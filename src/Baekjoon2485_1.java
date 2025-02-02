import java.io.*;
import java.util.*;

public class Baekjoon2485_1 {
    static int n, ret = 0;
    static List<Integer> li = new ArrayList<>();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int t = 0, before = 0;

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(i > 0){
                li.add(temp - before);
                t = go(t, li.get(li.size() - 1));
            }
            before = temp;
        }

        for (int x : li) {
            ret += x / t - 1;
        }

        System.out.println(ret);
    }

    static int go(int a, int b){
        if(b == 0) return a;
        return go(b, a % b);
    }
}