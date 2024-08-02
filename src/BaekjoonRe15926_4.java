import java.util.*;
import java.io.*;
public class BaekjoonRe15926_4 {
    static int n, ret = 0, cnt = 0;
    static Stack<Integer> st = new Stack<>();
    static int[] a = new int[200004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') st.push(i);
            if(c == ')' && !st.isEmpty()){
                a[st.pop()] = 1;
                a[i] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(a[i] == 1) cnt++;
            else {
                ret = Math.max(ret, cnt);
                cnt = 0;
            }
        }
        ret = Math.max(ret, cnt);
        System.out.println(ret);
    }
}