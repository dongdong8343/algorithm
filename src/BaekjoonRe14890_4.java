import java.util.*;
import java.io.*;
public class BaekjoonRe14890_4 {
    static int n, l, ret = 0;
    static int[][] a = new int[104][104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            int cnt = 1; boolean no = false;
            for(int j = 0; j < n - 1; j++){
                if(a[i][j] == a[i][j + 1]) cnt++;
                else if(a[i][j] + 1 == a[i][j + 1] && cnt >= l) cnt = 1;
                else if(a[i][j] == a[i][j + 1] + 1 && cnt >= 0) cnt = -l + 1;
                else {
                    no = true;
                    break;
                }
            }
            if(!no && cnt >= 0) {
                ret++;
            }
        }
        for(int i = 0; i < n; i++){
            int cnt = 1; boolean no = false;
            for(int j = 0; j < n - 1; j++){
                if(a[j][i] == a[j + 1][i]) cnt++;
                else if(a[j][i] + 1 == a[j + 1][i] && cnt >= l) cnt = 1;
                else if(a[j][i] == a[j + 1][i] + 1 && cnt >= 0) cnt = -l + 1;
                else {
                    no = true;
                    break;
                }
            }
            if(!no && cnt >= 0) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}