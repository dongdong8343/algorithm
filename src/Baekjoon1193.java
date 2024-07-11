import java.util.*;
import java.io.*;
public class Baekjoon1193 {
    static int cnt = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx = 1;
        while(true){
            idx++;
            if(idx % 2 == 0){
                for(int i = idx - 1; i >= 1; i--){
                    cnt++;
                    if(cnt == n){
                        System.out.println(i + "/" + (idx - i));
                        return;
                    }
                }
            }else{
                for(int i = 1; i <= idx - 1; i++){
                    cnt++;
                    if(cnt == n){
                        System.out.println(i + "/" + (idx - i));
                        return;
                    }
                }
            }
        }
    }
}