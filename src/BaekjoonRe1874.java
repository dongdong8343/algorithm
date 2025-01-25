import java.io.*;
import java.util.*;
public class BaekjoonRe1874 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        int[] a = new int[100004];
        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++){
            st.push(i);
            sb.append('+');
            while(st.peek() == a[idx]){
                sb.append('-');
                st.pop();
                idx++;
                if(st.isEmpty()) break;
            }
        }

        if(st.isEmpty()) {
           for(char c : sb.toString().toCharArray()){
               System.out.println(c);
           }
        }
        else System.out.println("NO");

    }
}