import java.util.*;
import java.io.*;
public class Baekjoon17822 {
    static int n, m, t, ret = 0;
    static int[][] a = new int[54][54];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int idx = 1;
            int b = x;
            while(true){
                b = x * idx++;
                if(b > n) break;
                Deque<Integer> dq = new ArrayDeque<>();
                for(int i = 0; i < m; i++) dq.add(a[b][i]);
                if(d == 0) {
                    for(int i = 0; i < k; i++) dq.addFirst(dq.pollLast());
                }
                else {
                    for(int i = 0; i < k; i++) dq.addLast(dq.pollFirst());
                }
                for(int i = 0; i < m; i++) a[b][i] = dq.pollFirst();
            }

            boolean erase = false;
            int temp[][] = new int[54][54];
            for(int i = 0; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(a[j][i] != 0 && a[j][i] == a[j + 1][i]){
                        erase = true;
                        temp[j][i] = 1;
                        temp[j + 1][i] = 1;
                    }
                }
            }
            for(int i = 1; i <= n; i++){
                for(int j = 0; j < m; j++){
                    if(j == m - 1){
                        if(a[i][0] != 0 && a[i][0] == a[i][j]){
                            erase = true;
                            temp[i][0] = 1;
                            temp[i][j] = 1;
                        }
                    }else{
                        if(a[i][j] != 0 && a[i][j] == a[i][j + 1]){
                            erase = true;
                            temp[i][j] = 1;
                            temp[i][j + 1] = 1;
                        }
                    }
                }
            }
            for(int i = 1; i <= n; i++){
                for(int j = 0; j < m; j++){
                    if(temp[i][j] == 1) a[i][j] = 0;
                }
            }
            if(!erase){
                int sum = 0, cnt = 0;
                for(int i = 1; i <= n; i++){
                    for(int j = 0; j < m; j++){
                        if(a[i][j] != 0) {
                            sum += a[i][j];
                            cnt++;
                        }
                    }
                }
                double avg = (double)sum / cnt;
                for(int i = 1; i <= n; i++){
                    for(int j = 0; j < m; j++){
                        if(a[i][j] != 0) {
                            if(a[i][j] > avg) a[i][j] -= 1;
                            else if(a[i][j] < avg) a[i][j] += 1;
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != 0) {
                    ret += a[i][j];
                }
            }
        }
        System.out.println(ret);
    }
}