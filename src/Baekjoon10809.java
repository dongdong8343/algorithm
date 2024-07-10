import java.util.*;
import java.io.*;
public class Baekjoon10809 {
    static int[] v = new int[30];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i = 0; i < 26; i++) v[i] = -1;
        for(int i = 0; i < s.length(); i++){
            if(v[s.charAt(i) - 'a'] == -1) v[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < 26; i++) System.out.print(v[i] + " ");
    }
}