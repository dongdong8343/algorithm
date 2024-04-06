import java.util.*;
import java.io.*;
public class BaekjoonRe1436 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i = 666;
        while(true){
            if(String.valueOf(i).contains("666"))
                cnt++;
            if(cnt == n)
                break;
            i++;
        }
        System.out.println(i);
    }
}