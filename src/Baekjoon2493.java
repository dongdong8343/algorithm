import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Baekjoon2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.empty()) {
                if (height > stack.peek()[1]) {
                    stack.pop();
                } else {
                    System.out.printf("%d ", stack.peek()[0]);
                    break;
                }
            }
            if (stack.empty()) {
                System.out.printf("0 ");
            }
            stack.push(new int[]{i, height});
        }
    }
}
