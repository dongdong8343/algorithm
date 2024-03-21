import java.util.*;
import java.io.*;
public class map {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited = new int[3][3];
    static int[][] adj = new int[3][3];

    static public void go(int y, int x){
        visited[x][y] = 1;
        System.out.println(y + ", " + x);
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                if (adj[ny][nx] != 0 && visited[ny][nx] != 1)
                    go(ny, nx);
            }
        }
        return;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0);
    }
}
