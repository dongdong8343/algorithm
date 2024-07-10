import java.util.*;
import java.io.*;
public class Baekjoon2562 {
    static int max = 0, idx = -1;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            int a = Integer.parseInt(br.readLine());
            if(max < a){
                max = a;
                idx = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}