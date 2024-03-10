import java.util.*;
import java.io.*;
public class Baekjoon6198 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!st.empty()) {
                if (height < st.peek()) {
                    sum += st.size();
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(height);
        }
        System.out.println(sum);
    }
}
