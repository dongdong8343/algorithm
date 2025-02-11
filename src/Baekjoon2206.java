import java.io.*;
import java.util.*;

public class Baekjoon2206 {
    public static class Node {
        public int y;
        public int x;
        public int cnt;
        public boolean d;

        public Node(int y, int x, int cnt, boolean d) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.d = d;
        }
    }

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] a = new char[1004][1004];
    static boolean[][][] v = new boolean[1004][1004][2];
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        q.add(new Node(0, 0, 1, false));
        v[0][0][0] = true;

        while (!q.isEmpty()) {
            Node t = q.poll();
            if(t.y == n - 1 && t.x == m - 1) return t.cnt;
            for(int i = 0; i < 4; i++){
                int ny = t.y + dy[i];
                int nx = t.x + dx[i];
                int nCnt = t.cnt + 1;

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if(a[ny][nx] == '0') { // 벽이 아닌 경우
                    if(t.d && !v[ny][nx][1]) { // 벽을 부쉈던 적이 있는 경우
                        q.add(new Node(ny, nx, nCnt,true));
                        v[ny][nx][1] = true;
                    }else if(!t.d && !v[ny][nx][0]){ // 벽을 부순 적이 없는 경우
                        q.add(new Node(ny, nx, nCnt, false));
                        v[ny][nx][0] = true;
                    }
                } else { // 벽인 경우
                    if(!t.d && !v[ny][nx][1]) { // 벽을 부순 적이 없고 부숴졌던 벽이 아닌 경우(방문을 안한 경우)
                        q.add(new Node(ny, nx, nCnt, true));
                        v[ny][nx][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}