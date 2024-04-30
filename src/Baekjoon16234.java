import java.util.*;
import java.io.*;
public class Baekjoon16234 {
    static int n, l, r, flag = 0, cnt = 0;
    static int[][] map = new int[54][54];
    static int[][] visited = new int[54][54];
    static int[][] area = new int[54][54];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1) continue;
            else if(Math.abs(map[y][x] - map[ny][nx]) >= l && Math.abs(map[y][x] - map[ny][nx]) <= r){
                flag = 1;
                area[ny][nx] = cnt;
                area[y][x] = cnt;
                dfs(ny, nx);
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while(true){
            visited = new int[54][54];
            area = new int[54][54];
            cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] == 0){
                        flag = 0;
                        cnt++;
                        dfs(i, j);
                        if(flag == 0) cnt--;
                    }
                }
            }
            if(cnt == 0) break;

            int[] ret = new int[cnt + 1];
            int[] num = new int[cnt + 1];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ret[area[i][j]] += map[i][j];
                    num[area[i][j]]++;
                }
            }

            for(int i = 1; i <= cnt; i++){
                ret[i] /= num[i];
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(area[i][j] == 0) continue;
                    map[i][j] = ret[area[i][j]];
                }
            }
            day++;
        }
        System.out.println(day);
    }
}
