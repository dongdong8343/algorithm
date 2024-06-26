import java.util.*;
import java.io.*;
public class Baekjoon1094 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int cnt = 1;
        while(x != 1){
            if((x & 1) == 1) cnt++;
            x /= 2;
        }
        System.out.println(cnt);
    }
}