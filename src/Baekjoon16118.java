import java.util.*;
import java.io.*;

public class Baekjoon16118 {
    static int n, m, ret = 0;
    static int[][] arr = new int[4004][4004];

    static class Node {
        int here, d, s;  // s: 속도 상태 (1=빠름, 2=느림)
        Node(int here, int d, int s) {
            this.here = here;
            this.d = d;
            this.s = s;
        }
    }

    static int[] dijkstra_fox() {
        int[] dist = new int[4004];
        Arrays.fill(dist, 987654321);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.d));
        dist[1] = 0;
        pq.add(new Node(1, 0, 0));
        while (!pq.isEmpty()) {
            Node t = pq.poll();
            int here = t.here;
            int d = t.d;
            if (d != dist[here]) continue;
            for (int i = 1; i <= n; i++) {
                if (arr[here][i] == -1) continue;
                int dis = arr[here][i];
                if (dist[i] > dis + d) {
                    dist[i] = dis + d;
                    pq.add(new Node(i, dist[i], 0));
                }
            }
        }
        return dist;
    }

    static int[][] dijkstra_wolf() {
        int[][] dist = new int[4004][2];  // 0: 빠르게, 1: 느리게 이동 시 거리
        for (int i = 0; i < 4004; i++) {
            Arrays.fill(dist[i], 987654321);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.d));
        dist[1][0] = 0;  // 처음에는 빠르게 출발
        pq.add(new Node(1, 0, 0));  // 0: 빠르게 이동하는 상태
        while (!pq.isEmpty()) {
            Node t = pq.poll();
            int here = t.here;
            int d = t.d;
            int s = t.s;
            if (d != dist[here][s]) continue;
            for (int i = 1; i <= n; i++) {
                if (arr[here][i] == -1) continue;
                int dis = arr[here][i];
                int _s = (s == 0) ? 1 : 0;  // 빠르게 이동 후에는 느리게, 느리게 이동 후에는 빠르게
                if (s == 0) dis /= 2;  // 빠르게 이동할 때
                else dis *= 2;  // 느리게 이동할 때
                if (dist[i][_s] > dis + d) {
                    dist[i][_s] = dis + d;
                    pq.add(new Node(i, dist[i][_s], _s));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int[] row : arr) {
            Arrays.fill(row, -1);  // 도로가 없는 경우 -1로 초기화
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) * 2;  // 도로의 길이를 2배로 저장
            arr[a][b] = c;
            arr[b][a] = c;
        }
        int[] fox = dijkstra_fox();
        int[][] wolf = dijkstra_wolf();

        for (int i = 2; i <= n; i++) {
            int wolf_min = Math.min(wolf[i][0], wolf[i][1]);  // 빠르게 또는 느리게 간 것 중 최단 거리 선택
            if (fox[i] < wolf_min) ret++;  // 여우가 늑대보다 빨리 도착한 경우
        }
        System.out.println(ret);
    }
}
