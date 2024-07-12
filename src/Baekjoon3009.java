import java.util.*;
import java.io.*;
public class Baekjoon3009 {
    static int ny, nx;
    static int[]cntx = new int[1004];
    static int[]cnty = new int[1004];
    static int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cntx[x]++;
            cnty[y]++;
            if(x1 == 0) x1 = x;
            else if(x1 != x) x2 = x;
            if(y1 == 0) y1 = y;
            else if(y1 != y) y2 = y;
        }
        if(cntx[x1] < cntx[x2]) nx = x1;
        else nx = x2;
        if(cnty[y1] < cnty[y2]) ny = y1;
        else ny = y2;
        System.out.println(nx + " " + ny);
    }
}