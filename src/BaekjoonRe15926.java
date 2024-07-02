import java.util.*;
import java.io.*;
public class BaekjoonRe15926 {
    static int cnt, n, max = 0;
    static String s;
    static int[] arr;
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') st.push(i);
            else if(!st.isEmpty()){
                arr[st.pop()] = 1;
                arr[i] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == 1) {
                cnt++;
                max = Math.max(cnt, max);
            }else cnt = 0;
        }
        System.out.println(max);
    }
}