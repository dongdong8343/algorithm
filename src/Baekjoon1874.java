import java.util.*;
import java.io.*;
public class Baekjoon1874 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> st = new Stack<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            st.push(i);
            sb.append('+');
            while (st.peek() == arr[index]) {
                st.pop();
                sb.append('-');
                index++;
                if (st.empty()) {
                    break;
                }
            }
        }
        if (!st.empty()) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < sb.length(); i++) {
                System.out.println(sb.charAt(i));
            }
        }
    }
}
