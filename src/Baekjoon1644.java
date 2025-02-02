import java.io.*;
import java.util.*;
public class Baekjoon1644 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        boolean[] che = new boolean[4000004];
        List<Integer> li = new ArrayList<>();

        che[0] = true; che[1] = true;
        for(int i = 2; i < 4000004; i++){
            if(che[i]) continue;
            for(int j = i * 2; j < 4000004; j += i){
                che[j] = true;
            }
        }

        for(int i = 2; i < 4000004; i++){
            if(!che[i]) li.add(i);
        }

        int sum = 0, l = 0, r = 0;
        while(true){
            if(sum >= n){
                if(sum == n) cnt++;
                sum -= li.get(l++);
            }else{
                sum += li.get(r++);
            }
            if(r >= li.size()) break;
        }
        while(l < li.size()) {
            sum -= li.get(l++);
            if(sum == n) cnt++;
        }

        System.out.println(cnt);
    }
}