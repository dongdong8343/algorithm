import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            while (!stack.empty()) {
                if (temp > stack.peek()[1]) {
                    arr[stack.pop()[0]] = temp;
                } else {
                    break;
                }
            }
            stack.push(new int[]{i, temp});
        }
        while (!stack.empty()) {
            arr[stack.pop()[0]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
