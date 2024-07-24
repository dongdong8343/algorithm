import java.util.*;
import java.io.*;
public class BaekjoonRe17825_1 {
    static List<Integer>[] adj = new List[54];
    static int[] v = new int[104];
    static int[] a = new int[12];
    static int[] mal = new int[4];
    static int go(int here){
        if(here == 10) return 0;
        int ret = 0;
        for(int i = 0; i < 4; i++){
            int t = mal[i];
            int n = move(t, a[here]);
            if(ismal(n, i)) continue;
            mal[i] = n;
            ret = Math.max(ret, go(here + 1) + v[n]);
            mal[i] = t;
        }
        return ret;
    }
    static int move(int now, int cnt){
        if(now == 100) return 100;
        if(adj[now].size() >= 2){
            now = adj[now].get(1);
            cnt--;
        }
        if(cnt > 0){
            Queue<Integer> q = new LinkedList<>();
            int there = 0;
            q.add(now);
            while(!q.isEmpty()){
                int x = q.poll();
                there = adj[x].get(0);
                q.add(there);
                if(there == 100) break;
                cnt--;
                if(cnt == 0) break;
            }
            return there;
        }else return now;
    }
    static boolean ismal(int now, int idx){
        if(now == 100) return false;
        for(int i = 0; i < 4; i++){
            if(i == idx) continue;
            if(now == mal[i]) return true;
        }
        return false;
    }
    static void setMap(){
        for(int i = 0; i < 54; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i <= 19; i++) adj[i].add(i + 1);
        adj[5].add(21); adj[21].add(22); adj[22].add(23); adj[23].add(24);
        adj[10].add(27); adj[27].add(28); adj[28].add(24); adj[15].add(29);
        adj[29].add(30); adj[30].add(31); adj[31].add(24); adj[24].add(25);
        adj[25].add(26); adj[26].add(20); adj[20].add(100);

        v[1] = 2; v[2] = 4; v[3] = 6; v[4] = 8; v[5] = 10;
        v[6] = 12; v[7] = 14; v[8] = 16; v[9] = 18; v[10] = 20;
        v[11] = 22; v[12] = 24; v[13] = 26; v[14] = 28; v[15] = 30;
        v[16] = 32; v[17] = 34; v[18] = 36; v[19] = 38; v[20] = 40;
        v[21] = 13; v[22] = 16; v[23] = 19; v[24] = 25; v[25] = 30;
        v[26] = 35; v[27] = 22; v[28] = 24; v[29] = 28; v[30] = 27; v[31] = 26;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) a[i] = Integer.parseInt(st.nextToken());
        System.out.println(go(0));
    }
}