import java.util.*;
import java.io.*;

public class Baekjoon11328 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            String input = br.readLine();
            String[] str = input.split(" ", 2);

            // 첫 번째 문자열에 대한 처리
            for (int j = 0; j < str[0].length(); j++) {
                char ch1 = str[0].charAt(j);
                arr1[ch1 - 'a']++;
            }

            // 두 번째 문자열에 대한 처리
            for (int j = 0; j < str[1].length(); j++) {
                char ch2 = str[1].charAt(j);
                arr2[ch2 - 'a']++;
            }

            boolean equal = Arrays.equals(arr1, arr2);
            if (equal) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
