import java.util.*;
import java.io.*;
public class BaekjoonRe1644_4 {
    static int n, ret = 0, sum, l, h;
    static int[] che = new int[4000004];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(0);
            return;
        }
        for(int i = 2; i <= n; i++){
            if(che[i] == 1) continue;
            for(int j = i * 2; j <= n; j += i){
                che[j] = 1;
            }
        }
        for(int i = 2; i <= n; i++){
            if(che[i] == 0) {
                li.add(i);
            }
        }
        sum = 2; l = 0; h = 0;
        while(true){
            if(sum <= n){
                if(sum == n) ret++;
                h++;
                if(h == li.size()) break;
                sum += li.get(h);
            }else sum -= li.get(l++);
        }
        System.out.println(ret);
    }
}