import java.io.*;
import java.util.*;

public class BaekjoonRe1978 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int cnt = 0;
        boolean[] che = new boolean[1004];

        che[0] = true;
        che[1] = true;

        for(int i = 2; i < 1004; i++){
            if(che[i]) continue;
            for(int j = i * 2; j < 1004; j += i){
                che[j] = true;
            }
        }

        for(String t : s){
            if(!che[Integer.parseInt(t)]) cnt++;
        }

        System.out.println(cnt);
    }
}