import java.util.*;
import java.io.*;
public class Baekjoon1158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        sb.append('<');
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    if (list.size() == 1) {
                        sb.append(list.remove());
                    } else {
                        sb.append(list.remove());
                        sb.append(", ");
                    }
                }else{
                    list.add(list.remove());
                }
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}
