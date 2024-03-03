import java.util.*;
import java.io.*;
public class Baekjoon1919 {
    public static int[] AlSum(String str){
        int[] arr = new int[26];
        for(int i = 0; i < str.length(); i++){
            char a = str.charAt(i);
            arr[a - 'a']++;
        }
        return arr;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        String st1, st2;
        st1 = br.readLine();
        st2 = br.readLine();

        int[] arr1 = AlSum(st1);
        int[] arr2 = AlSum(st2);

        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                n += Math.abs(arr1[i] - arr2[i]);
            }
        }

        System.out.println(n);
    }
}
