import java.io.*;
import java.util.*;

public class Baekjoon7569 {
    static class Node{
        public int x;
        public int y;
        public int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int m, n, h, ret = -1, cnt = 0;
    static int[][][] a = new int[104][104][104];
    static Queue<Node> q1 = new LinkedList<>();
    static Queue<Node> q2 = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dz = {1, -1};

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for(int k = 0; k < h; k++){ //h
            for(int i = 0; i < n; i++){ //y
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < m; j++){ //x
                    a[i][j][k] = Integer.parseInt(st.nextToken());
                    if(a[i][j][k] == 1) {
                        q1.add(new Node(j, i, k));
                        a[i][j][k] = 1;
                    }
                    if(a[i][j][k] == 0) cnt++;
                }
            }
        }

        if(cnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(ret);
    }

    static void bfs(){
        while(!q1.isEmpty()){
            ret++;
            q2 = q1;
            q1 = new LinkedList<>();
            while(!q2.isEmpty()){
                Node t = q2.poll();
                int x = t.x, y = t.y, z = t.z;
                for(int i = 0; i < 2; i++) {
                    int nz = z + dz[i];
                    if(nz < 0 || nz >= h || a[y][x][nz] != 0) continue;
                    q1.add(new Node(x, y, nz));
                    a[y][x][nz] = 1;
                }
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || a[ny][nx][z] != 0) continue;
                    q1.add(new Node(nx, ny, z));
                    a[ny][nx][z] = 1;
                }
            }
        }
    }
}