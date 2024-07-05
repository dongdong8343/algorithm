import java.util.*;
import java.io.*;
public class BaekjoonRe15926_2 {
    static int cnt = 0, ret = 0, n;
    static int[] a;
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        a = new int[n + 4];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') st.push(i);
            else if(!st.isEmpty() && s.charAt(i) == ')'){
                a[st.pop()] = 1;
                a[i] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(a[i] == 1) cnt++;
            else{
                ret = Math.max(ret, cnt);
                cnt = 0;
            }
        }
        ret = Math.max(ret, cnt);
        System.out.println(ret);
    }
}
