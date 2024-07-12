import java.util.*;
import java.io.*;
public class BaekjoonRe15926_3 {
    static int n, max = 0, cnt = 0;
    static String s;
    static Stack<Integer> st = new Stack<>();
    static int[] v = new int[200004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') st.push(i);
            else{
                if(!st.isEmpty()){
                    v[st.pop()] = 1;
                    v[i] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(v[i] == 1) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        max = Math.max(max, cnt);
        System.out.println(max);
    }
}