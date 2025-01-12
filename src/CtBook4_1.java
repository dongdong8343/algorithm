import java.io.*;
import java.util.*;
public class CtBook4_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        String s = br.readLine();
        int n = Integer.parseInt(String.valueOf(s.charAt(1))) - 1;
        int m = (int)s.charAt(0) - 'a';

        for(int i = 0; i < 8; i++){
            int nx = m + dx[i];
            int ny = n + dy[i];

            if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
            cnt++;
        }

        System.out.println(cnt);
    }
}