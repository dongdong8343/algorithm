import java.io.*;
import java.util.*;

public class Baekjoon6588 {
    static int n;
    static boolean[] che = new boolean[1000004];
    static List<Integer> oddNums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        che[0] = true; che[1] = true;
        for (int i = 2; i < 1000004; i++) {
            if (che[i]) continue;
            for (int j = i * 2; j < 1000004; j += i) {
                che[j] = true;
            }
        }

        for (int i = 2; i < 1000004; i++) {
            if (!che[i] && i % 2 != 0) oddNums.add(i);
        }

        outer:
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            for(int i = n; i > 2; i--){
                if(!che[i] && !che[n - i]) {
                    sb.append(n + " = " + (n - i) + " + " + i + "\n");
                    continue outer;
                }
            }
            sb.append("Goldbach's conjecture is wrong.");
        }

        System.out.print(sb.toString());
    }
}