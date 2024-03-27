import java.io.*;
import java.util.*;
public class Baekjoon10709 {
    static char[][] map;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        for(int i = 0; i < h; i++){
            String s = br.readLine();
            for(int j = 0; j < w; j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < h; i++){
            int c = -1;
            for(int j = 0; j < w; j++){
                if(map[i][j] == 'c'){
                    c = j;
                    System.out.print(0 + " ");
                }else if(c != -1)
                    System.out.print((j - c) + " ");
                else
                    System.out.print(-1 + " ");
            }
            System.out.println();
        }
    }
}
