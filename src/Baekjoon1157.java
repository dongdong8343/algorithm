import java.util.*;
import java.io.*;
public class Baekjoon1157 {
    static String s;
    static int[] a = new int[26];
    static int max = 0, cnt = 0;
    static char al;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            char c = String.valueOf(s.charAt(i)).toUpperCase().charAt(0);
            a[c - 'A']++;
            if(max < a[c - 'A']){
                max = a[c - 'A'];
                al = c;
            }
        }
        for(int i = 0; i < 26; i++){
            if(max == a[i]) cnt++;
        }
        if(cnt > 1) System.out.println('?');
        else System.out.println(al);
    }
}