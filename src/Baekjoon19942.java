import java.util.*;
import java.io.*;

public class Baekjoon19942 {
    static int n, min = 987654321;
    static List<Integer> ret = new ArrayList<>();
    static int[] m;
    static int[][] info;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new int[4];
        info = new int[n][5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < (1 << n); i++) {
            int[] cntInfo = new int[5];
            List<Integer> li = new ArrayList<>();
            int ok = 1;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    li.add(j);
                    for (int k = 0; k < 5; k++) {
                        cntInfo[k] += info[j][k];
                    }
                }
            }

            for (int k = 0; k < 4; k++) {
                if (cntInfo[k] < m[k]) {
                    ok = 0;
                    break;
                }
            }

            if (ok == 1) {
                if (cntInfo[4] == min) {
                    if (compareLists(li, ret) < 0) {
                        ret = new ArrayList<>(li);
                    }
                } else if (cntInfo[4] < min) {
                    min = cntInfo[4];
                    ret = new ArrayList<>(li);
                }
            }
        }

        if (min != 987654321) {
            System.out.println(min);
            for (int i : ret) {
                System.out.print((i + 1) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static int compareLists(List<Integer> list1, List<Integer> list2) {
        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i) - list2.get(i);
            }
        }
        return list1.size() - list2.size();
    }
}
