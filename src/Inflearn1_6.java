import java.util.*;
import java.io.*;

public class Inflearn1_6 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] a = new int[30];
        String s = br.readLine();
        for(char c : s.toCharArray()){
            if(a[c - 'a'] == 0){
                a[c - 'a'] = 1;
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}