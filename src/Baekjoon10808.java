import java.util.*;
import java.io.*;
public class Baekjoon10808 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            int n = a - 'a';
            arr[n]++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
