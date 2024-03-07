import java.util.*;
import java.io.*;
public class Baecjoon10773 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        int n = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                st.pop();
            } else {
                st.push(n);
            }
        }
        while (!st.empty()) {
            sum += st.pop();
        }
        System.out.println(sum);
    }
}
