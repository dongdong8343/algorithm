import java.util.*;
import java.io.*;
public class Baekjoon1436 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 666; ; i++){
            if(String.valueOf(i).contains("666")){
                n--;
                if(n == 0) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
