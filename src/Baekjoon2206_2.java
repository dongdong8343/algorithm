import java.io.*;
import java.util.*;

public class Baekjoon2206_2 {
    static class Node{
        public int y, x, b;

        public Node(int y, int x, int b){
            this.y = y;
            this.x = x;
            this.b = b;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] a = new int[1004][1004];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        if(n == 0 && m == 0) {
            System.out.println(0);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        int[][][] v = new int[1004][1004][2];

        q.add(new Node(0, 0, 0));
        v[0][0][0] = 1;

        while(!q.isEmpty()){
            Node t = q.poll();

            if(t.y == n - 1 && t.x == m - 1) {
                System.out.println(v[t.y][t.x][t.b]);
                return;
            }

            for(int i = 0; i < 4; i++){
                int ny = t.y + dy[i];
                int nx = t.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if(a[ny][nx] == 1) {
                    if(t.b == 0 && v[ny][nx][1] == 0){
                        q.add(new Node(ny, nx, 1));
                        v[ny][nx][1] = v[t.y][t.x][t.b] + 1;
                    }
                }else{
                    if(t.b == 1 && v[ny][nx][1] == 0){
                        q.add(new Node(ny, nx, t.b));
                        v[ny][nx][1] = v[t.y][t.x][1] + 1;
                    }
                    if(t.b == 0 && v[ny][nx][0] == 0){
                        q.add(new Node(ny, nx, t.b));
                        v[ny][nx][0] = v[t.y][t.x][0] + 1;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}