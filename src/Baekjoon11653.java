import java.util.*;
import java.io.*;
public class Baekjoon11653 {
    static int n, idx = 0;
    static boolean[] che = new boolean[10000004];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 2; i <= 10000000; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= 10000000; j+=i){
                che[j] = true;
            }
        }
        for(int i = 2; i <= 10000000; i++){
            if(!che[i]) li.add(i);
        }
        n = Integer.parseInt(br.readLine());
        while(n != 1){
            if(n % li.get(idx) == 0){
                n /= li.get(idx);
                System.out.println(li.get(idx));
            }
            else idx++;
            if(n == 1) break;
        }
    }
}