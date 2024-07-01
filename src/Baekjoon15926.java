import java.util.*;
import java.io.*;
public class Baekjoon15926 {
    static int n, cnt = 0, max = 0;
    static int[] arr = new int[200004];
    static String s;
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(i);
            else if(!st.empty()){
                arr[st.pop()] = 1;
                arr[i] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == 1) {
                cnt++;
                max = Math.max(cnt, max);
            }
            else cnt = 0;
        }
        System.out.println(max);
    }
}