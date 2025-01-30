import java.io.*;
import java.util.*;

public class BaekjoonRe1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");

        boolean[] che = new boolean[1000004];

        che[0] = true;
        che[1] = true;

        for (int i = 2; i < 1000004; i++) {
            if (che[i]) continue;
            for (int j = i * 2; j < 1000004; j += i) {
                che[j] = true;
            }
        }

        int start = Integer.parseInt(cmd[0]);
        int end = Integer.parseInt(cmd[1]);

        for (int i = start; i <= end; i++) {
            if (!che[i]) System.out.println(i);
        }
    }
}