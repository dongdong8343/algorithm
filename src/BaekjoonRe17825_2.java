import java.util.*;
import java.io.*;
public class BaekjoonRe17825_2 {
    static int ret = 0;
    static int[] a = new int[14];
    static List<Integer>[] map = new List[54];
    static int[] sc = new int[104];
    static void setMap(){
        for(int i = 0; i < 54; i++)
            map[i] = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            map[i].add(i + 1);
        }
        map[5].add(21); map[21].add(22); map[22].add(23); map[23].add(24);
        map[15].add(27); map[27].add(26); map[26].add(25); map[25].add(24);
        map[10].add(28); map[28].add(29); map[29].add(24); map[24].add(30);
        map[30].add(31); map[31].add(20); map[20].add(100);

        for(int i = 1; i < 21; i++){
            sc[i] = i * 2;
        }
        sc[21] = 13; sc[22] = 16; sc[23] = 19; sc[24] = 25;
        sc[25] = 26; sc[26] = 27; sc[27] = 28; sc[28] = 22;
        sc[29] = 24; sc[30] = 30; sc[31] = 35;
    }
    static int[] mal = new int[4];
    static int move(int now, int num){
        if(now == 100) return 100;
        if(map[now].size() == 2){
            now = map[now].get(1);
            num--;
        }
        int next;
        if(num > 0){
            while(true){
                next = map[now].get(0);
                num--;
                if(num == 0) break;
                if(next == 100) break;
                now = next;
            }
            return next;
        }else return now;
    }
    static boolean ismal(int h, int n){
        if(h == 100) return false;
        for(int i = 0; i < 4; i++){
            if(i == n) continue;
            if(mal[i] == h) return true;
        }
        return false;
    }
    static void go(int here, int score){
        if(here == 10){
            ret = Math.max(score, ret);
            return;
        }
        for(int i = 0; i < 4; i++){
            int now = mal[i];
            int next = move(now, a[here]);
            if(ismal(next, i)) continue;
            mal[i] = next;
            go(here + 1, score + sc[next]);
            mal[i] = now;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 0);
        System.out.println(ret);
    }
}