import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon16235 {
    static int n, m, k, ret = 0;
    static int[][] a = new int[14][14];
    static int[][] temp = new int[14][14];
    static int[][] death = new int[14][14];
    static List<Integer>[][] t = new List[14][14];
    static Queue<Point> q = new LinkedList<>();
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static void spring(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                Collections.sort(t[i][j], (o1, o2) -> {
                    return o1 - o2;
                });
                for(int s = 0; s < t[i][j].size(); s++){
                    if(t[i][j].get(s) <= temp[i][j]){
                        temp[i][j] -= t[i][j].get(s);
                        t[i][j].set(s, t[i][j].get(s) + 1);
                    }else{
                        death[i][j] += t[i][j].get(s) / 2;
                        t[i][j].remove(s);
                        q.add(new Point(j, i));
                        s--;
                    }
                }
            }
        }
    }
    static void summer(){
        while(!q.isEmpty()){
            Point p = q.poll();
            temp[p.y][p.x] += death[p.y][p.x];
            death[p.y][p.x] = 0;
        }
    }
    static void fall(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int s = 0; s < t[i][j].size(); s++){
                    if(t[i][j].get(s) % 5 == 0){
                        for(int idx = 0; idx < 8; idx++){
                            int ny = i + dy[idx];
                            int nx = j + dx[idx];
                            if(ny <= 0 || nx <= 0 || ny > n || nx > n) continue;
                            t[ny][nx].add(0, 1);
                        }
                    }
                }
            }
        }
    }
    static void winter(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                temp[i][j] += a[i][j];
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = 5;
                t[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            t[x][y].add(z);
        }
        while(k-- > 0){
            q = new LinkedList<>();
            spring();
            summer();
            fall();
            winter();
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(!t[i][j].isEmpty()) ret += t[i][j].size();
            }
        }
        System.out.println(ret);
    }
}