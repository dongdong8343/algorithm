import java.util.*;
import java.io.*;

public class Baekjoon6549 {

    static class Rectangle {
        int height;
        int position;

        public Rectangle(int height, int position) {
            this.height = height;
            this.position = position;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            Stack<Rectangle> stack = new Stack<>();
            long maxArea = 0;

            for (int i = 0; i < n; i++) {
                int height = Integer.parseInt(st.nextToken());

                int start = i;
                while (!stack.isEmpty() && stack.peek().height > height) {
                    Rectangle rect = stack.pop();
                    long area = (long) (i - rect.position) * rect.height;
                    maxArea = Math.max(maxArea, area);
                    start = rect.position;
                }

                stack.push(new Rectangle(height, start));
            }

            while (!stack.isEmpty()) {
                Rectangle rect = stack.pop();
                long area = (long) (n - rect.position) * rect.height;
                maxArea = Math.max(maxArea, area);
            }

            System.out.println(maxArea);
        }
    }
}
