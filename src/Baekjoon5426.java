import java.util.*;
import java.io.*;
public class Baekjoon5426 {
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            char[] arr = new char[s.length() + 4];

            for(int j = 1; j <= s.length(); j++){
                arr[j] = s.charAt(j - 1);
            }

            int a = (int) Math.sqrt(s.length());
            int start = a;
            for(int j = 0; j < a; j++){
                int here = start;
                for(int k = here; k <= s.length(); k += a){
                    sb.append(arr[k]);
                }
                start--;
            }
            System.out.println(sb.toString());
        }
    }
}