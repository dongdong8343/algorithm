import java.util.*;
import java.io.*;
public class BaekjoonBit1987 {
    static int r, c, ret = 0;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void go(int x, int y, int a, int cnt){
        ret = Math.max(ret, cnt);
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || ny >= r || nx >= c) continue;
            if((a & (1 << (map[ny][nx] - 'A'))) != 0) continue;
            int b = a | (1 << (map[ny][nx] - 'A'));
            go(nx, ny, b, cnt + 1);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r + 4][c + 4];
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++)
                map[i][j] = s.charAt(j);
        }
        int num = (1 << (map[0][0] - 'A'));
        go(0, 0, num, 1);
        System.out.println(ret);
    }
}