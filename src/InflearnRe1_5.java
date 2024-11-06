import java.util.*;
import java.io.*;
public class InflearnRe1_5 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] a = s.toCharArray();
        int lt = 0, rt = s.length() - 1;
        while(lt < rt){
            if(!Character.isAlphabetic(a[lt])) lt++;
            else if(!Character.isAlphabetic(a[rt])) rt--;
            else{
                char t = a[lt];
                a[lt] = a[rt];
                a[rt] = t;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(a));
    }
}