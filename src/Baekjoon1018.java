import java.util.*;
import java.io.*;
public class Baekjoon1018 {
    static int n, m, ret = 987654321;
    static char[][] a = new char[54][54];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                char c = s.charAt(j);
                a[i][j] = c;
            }
        }
        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                int cnt = 0;
                boolean b = a[i][j] == 'B';
                for(int k = i; k < i + 8; k++){
                    for(int l = j; l < j + 8; l++){
                        if(k == i && l == j) continue;
                        if(b && a[k][l] == 'W') b = false;
                        else if(!b && a[k][l] == 'B') b = true;
                        else {
                            b = !b;
                            cnt++;
                        }
                    }
                    b = !b;
                }
                int min = Math.min(cnt, 64 - cnt);
                ret = Math.min(ret, min);
            }
        }
        System.out.println(ret);
    }
}