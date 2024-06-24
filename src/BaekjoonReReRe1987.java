import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReRe1987 {
    static int r, c, max = 0;
    static char[][] map = new char[24][24];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void go(int y, int x, int[] a, int cnt){
        if(cnt > max) max = cnt;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c || a[map[ny][nx] - 'A'] == 1) continue;
            a[map[ny][nx] - 'A'] = 1;
            go(ny, nx, a, cnt + 1);
            a[map[ny][nx] - 'A'] = 0;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
            }
        }
        int[] al = new int[26];
        al[map[0][0] - 'A'] = 1;
        go(0, 0, al, 1);
        System.out.println(max);
    }
}